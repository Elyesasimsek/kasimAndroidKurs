package com.example.a005nesnetabanliprogramlama;

public class Mudur extends Personel{
    public void iseAl(Personel personel){
        personel.iseAlindi();
    }

    public  void terfiEttir(Personel personel){
        if (personel instanceof Ogretmen){
            ((Ogretmen) personel).maasArttir();
        }
        if (personel instanceof Isci){
            System.out.println("İşçiler terfi alamaz.");
        }
    }
}
