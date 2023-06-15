package com.example.sharedpreferenceloginekran

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferenceloginekran.databinding.ActivityAnaEkranBinding

class AnaEkranActivity : AppCompatActivity() {
    lateinit var binding:ActivityAnaEkranBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAnaEkranBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sp=getSharedPreferences("Giris", Context.MODE_PRIVATE)
        val ka=sp.getString("kullaniciAdi", "kullanici adi yok")
        val s=sp.getString("sifre","sifre yok" )
        binding.textViewCikti.text="Kullanıcı Adı:$ka Şifre:$s"
        binding.buttonCikisYap.setOnClickListener {
            val editor=sp.edit()
            editor.remove("kullaniiciAdi")
            editor.remove("sifre")
            editor.commit()
            startActivity(Intent(this@AnaEkranActivity,MainActivity::class.java))
            finish()
        }
    }
}