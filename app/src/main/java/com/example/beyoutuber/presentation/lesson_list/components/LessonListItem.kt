package com.example.beyoutuber.presentation.lesson_list.components

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.example.beyoutuber.R
import com.example.beyoutuber.domain.model.Lesson


//@Preview(showBackground = true)
@Composable
fun LessonListItem(
    lesson: Lesson,
    onItemClick: ((Lesson) -> Unit)?
)
{
//    val lesson=Lesson(icon ="https://furkansandal.com/youtuber_app/assets/tick.jpg",
//        baslik= "Youtube’dan Para Kazanmaya Giriş",
//        icerik="<img src='https://furkansandal.com/youtuber_app/assets/ytb3.jpg' width='100%' />\n<h1><center><strong>Hadi Başlayalım</strong></center></h1><br><p>‘<strong>Youtube para kazanma</strong>‘ temasını geniş bir çerçevede incelediğimiz bu yazımızı okumaya başlamadan önce, yazının uzun ve detaylı bilgiler içerdiğini söylemekte fayda var. Fakat yayınladığımız bu detaylı rehber alt başlıklar halinde bölüm bölüm ayrıldığı için, zaten bildiğiniz veya merak etmediğiniz bölümleri direk atlayabilir, ilginizin çektiği ve faydalı gördüğünüz kısımları okuyabilirsiniz. Görüşlerinizi yazının en altında bulunan yorum kısmı aracılığı ile bizimle paylaşabilir, diğer Youtube Yayıncı adaylarına tecrübelerinizi aktarabilirsiniz.</p>\n<br><p>21.yüzyılda para kazanmanın en kolay yolu interneti kullanmaktır. Dikkat ettiyseniz internetten para kazanmaktır demedim. Bunun sebebi ise genel olarak insanların internetten para kazanma olayına odaklanmasıdır. Unutmayın internetten para kazanılmaz, interneti kullanarak para kazanılır.</p>\n<br><p>Son dönemlerde en popüler olan gelir elde etme yollarından birisi olarak <strong>Youtube’dan para kazanma</strong> gösterilmektedir.Bunun için birçok kişi kanal açmış, sahte veya edit’lenmiş videoları hesabına yükleyerek para kazanmaya çalışmıştır. Ancak bu hesapların hepsi eninde sonunda telif ihlali nedeniyle ya askıya alınmış yada süresiz kapatılmıştır. Youtube’dan para kazanılır mı kazanılmaz mı diye merak ediyorsanız buna cevabım ‘Evet’! Youtube’dan gerçekten para kazanabilirsiniz. Ancak bunun için orijinal ve farklı bir şeyler yapmanız gerekir. Bu içerikte Youtube’dan para kazanma olayını tüm detayları ile inceleyeceğiz ve aklınızdaki soruların cevaplarını içeriği tamamen okuduğunuzda bulabileceksiniz. Adım adım <strong>Youtube’dan nasıl para kazanılır</strong> tüm detayları ile başlıyoruz:</p>\n<br><p><strong>Önemli Not:</strong> İçerik biraz uzun olacak ancak okuduğunuzda buna değecektir. Bu nedenle hiçbir yeri atlamadan tamamen okumanız sizin için daha faydalı olacaktır.</p>\n<p>Sırayı bozmadan giderseniz siz de bir YouTuber olup aylık gelirinizler dudak uçuklatabilirsiniz. Yapmanız gereken sadece, zamanınız oldukça sırayla okumaktır. \n\nİlk derslerimiz sadece sözel olup not almanızı tavsiye ederim. Devamında ki derslerde uygulamalı eğitimle devam ediyoruz.\n\nGeri gelip #1 numaralı ders ile içeriğe başlayabilirsiniz.</p>")//viewModel.state.value.lesson

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                if (onItemClick != null) {
                    onItemClick(lesson)
                }
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = lesson.icon,
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentDescription = lesson.icon,
            modifier = Modifier.clip(CircleShape),
            alignment = Alignment.CenterStart,
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = lesson.baslik,
            style=MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
            )
    }

}