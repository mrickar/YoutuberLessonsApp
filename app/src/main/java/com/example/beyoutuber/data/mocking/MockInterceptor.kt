package com.example.beyoutuber.data.mocking

import com.example.beyoutuber.BuildConfig
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.io.IOException
import java.net.URI

class MockInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        lateinit var response:Response
        if(IsMock.IS_MOCK)
        {
//            println("---------MOCK INTERCEPTOR-------------")
            // Get Request URI.
            val uri: URI = chain.request().url.toUri()
//            println("uri: ${uri}")
            // Get path String.
            var path: String = uri.path
//            println("path: ${path}")
            // Remove the starter slide '/'
            path = if (path.startsWith('/')) path.substring(1) else path
            // Get the json file text
            val responseString: String = readFromJson(path).orEmpty()

            response = Response.Builder()
                .code(200)
                .message(responseString)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(responseString.toByteArray().toResponseBody("application/json".toMediaType()))
//                .addHeader("content-type", "application/json")
                .build()


        } else{
            response=chain.proceed(chain.request())
        }
        return response
    }
    fun addMockInterceptorToBuilder(builder: OkHttpClient.Builder)
    {
        builder.addInterceptor(this)
    }
    private fun readFromJson(fileName:String):String?{

        return try {
//            println("fileName " + fileName)
            val jsonString = this::class.java.classLoader.getResource("$fileName.json").readText()
            jsonString
        } catch (e:IOException) {
//            println("COULDN'T FIND THE JSON FILE FOR MOCKING!")
            null
        }

    }
}