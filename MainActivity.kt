import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isPlaying = false
    private val songUrl = "https://www.dropbox.com/scl/fi/dgav25jp9t5r2jvnl868f/Deva-Deva-Brahmastra-128-Kbps.mp3?rlkey=gho5nolgq7t6cr0d2fg2vj068&raw=1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val playButton = Button(this)
        playButton.text = "Play"

        playButton.setOnClickListener {
            if (!isPlaying) {
                val intent = Intent(this, MusicService::class.java)
                intent.putExtra("songUrl", songUrl)
                startService(intent)
                playButton.text = "Pause"
                isPlaying = true
            } else {
                stopService(Intent(this, MusicService::class.java))
                playButton.text = "Play"
                isPlaying = false
            }
        }

        setContentView(playButton)
    }
}