package com.example.sharedpreferenceloginekran

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreferenceloginekran.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sp=getSharedPreferences("Giris", Context.MODE_PRIVATE)
        val otomatikgiriska=sp.getString("kullaniciAdi", "kullanici adi yok")
        val otomatikgiriss=sp.getString("sifre","sifre yok" )
        if(otomatikgiriska=="admin" && otomatikgiriss=="123"){
            startActivity(Intent(this@MainActivity,AnaEkranActivity::class.java))
            finish()
        }
        binding.buttonGiris.setOnClickListener {
            val ka=binding.editTextKullanici.text.toString()
            val s=binding.editTextSifre.text.toString()

            if(ka=="admin"&& s=="123"){
                var editor=sp.edit()
                editor.putString("kullaniciAdi",ka)
                editor.putString("sifre",s)
                editor.commit()
                startActivity(Intent(this@MainActivity,AnaEkranActivity::class.java))
                finish()
            }else{
                Toast.makeText(this,"hatalı giriş", Toast.LENGTH_SHORT).show()
            }

        }
    }
}