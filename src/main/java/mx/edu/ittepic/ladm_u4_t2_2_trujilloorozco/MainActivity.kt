package mx.edu.ittepic.ladm_u4_t2_2_trujilloorozco

import android.net.Uri
import android.os.Bundle
import android.provider.CallLog
import android.provider.MediaStore
import android.webkit.WebChromeClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val siEscrituraContactos =18

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



                button.setOnClickListener {
                    verHistorial()
                }
    }

    private fun verHistorial() {
//content://com.android.chrome.browser/bookmarks
        val AudioUri = MediaStore.Audio.Media.INTERNAL_CONTENT_URI
        val musicUri = MediaStore.Audio.Playlists.INTERNAL_CONTENT_URI

        var resultado =""
        var cursorHistorial = contentResolver.query(
            AudioUri,  null,null,null,null
        )
        if(cursorHistorial!!.moveToFirst()){
            do {
                var nombre = cursorHistorial.getString(cursorHistorial.getColumnIndex("title"))
                var album = cursorHistorial.getString(cursorHistorial.getColumnIndex("album"))
                var artista = cursorHistorial.getString(cursorHistorial.getColumnIndex("artist"))

               // var nombre = cursorHistorial.getString(cursorHistorial.getColumnIndex("DISPLAY_NAME"))


                resultado += "NOMBRE :"+nombre+"\nALBUM:"+album+"\nArtista :"+artista+"\n-----------\n"

            }while (cursorHistorial.moveToNext())
        }
        textView.setText(resultado)
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==siEscrituraContactos){
            setTitle("PERMISO OTORGADO")
        }

    }


}
