package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //String letter;


        ArrayList<String> syllable = new ArrayList<String>();
        ArrayList<Integer> vowelIndex = new ArrayList<Integer>();
        HashMap<Integer, String> vowellist = new HashMap<Integer, String>();
        HashMap<String, String> tukishCharacters = new HashMap<String, String>();
        String[] vowels = {"a", "e", "i", "I", "o", "O", "u", "U"};

        tukishCharacters.put("ç", "C");
        tukishCharacters.put("ö", "O");
        tukishCharacters.put("ğ", "G");
        tukishCharacters.put("ı", "I");
        tukishCharacters.put("ü", "U");
        tukishCharacters.put("ş", "S");
        System.out.println("Please enter the yor Turkish sentence");


        Scanner scan = new Scanner(System.in);
        String sentence = scan.nextLine();

        sentence = sentence.toLowerCase(Locale.ROOT);//HARFLERİ KÜÇÜK HARFE ÇEVİRİYOR
        System.out.println(sentence);

        for (int x = 0; x < sentence.length(); x++) {
            for (String character : tukishCharacters.keySet()) {
                if (String.valueOf(sentence.charAt(x)).equals(character)) {
                    sentence = sentence.replace(character, tukishCharacters.get(character));
                }
            }
        }
        //System.out.println(sentence + "  türkçe karakter düzeltmesi yapıldı");

        for (int x = 0; x < sentence.length(); x++) {
            for (String vowel : vowels) {
                if (String.valueOf(sentence.charAt(x)).equals(vowel)) {
                    vowellist.put(x, String.valueOf(sentence.charAt(x)));
                    vowelIndex.add(x);
                }
            }
        }
     //  for (int x : vowellist.keySet()) {

         //   System.out.println(x + " " + vowellist.get(x) + "  ünlülerin sıra numarası alındı");
         //   System.out.println(vowellist.size() + "  kelimede ki ünlü ");}
       // System.out.println((sentence.charAt(0) + " baş harf"));
        //System.out.println(sentence.length() + "  kelimenin uzunluğu");
        //for (int x : vowellist.keySet()) {
       //     System.out.println(x + " " + vowellist.get(x) + "  vowel hasmap");}
       // for (int x = 0; x < vowelIndex.size(); x++) {
         //   System.out.println(x + "  " + vowelIndex.get(x) + " ındex");}
       //System.out.println(vowelIndex.size() + vowelIndex.get(5)+"  küme genişliği");


        for (int x = 0; x <vowelIndex.size(); x++) {
            //System.out.println(x + "---------");
            //System.out.println(vowelIndex.get(x) + " kontrol x");
            if ((x + 1) < vowelIndex.size()) {
               // System.out.println(vowelIndex.get(x + 1) + " kontrol x+1");
            }
            if ((x - 1) >= 0) {
                //System.out.println(vowelIndex.get((x - 1)) + " kontrol x-1");
            }
            //tek heceliler
            if (vowelIndex.size() == 1) {
                syllable.add(sentence);
            } else {
                //sesli harf bireden fazla ise işlemi 3 parçada ele alınmalı. İlk hece,Orta kısım, Son hece
// a yı hesapladık
                if ((x + 1) < vowellist.size()) {
                    int a = (vowelIndex.get((x + 1))) - (vowelIndex.get(x));
                    //System.out.println(a + " sonra");
//ilk hece
                   if (vowelIndex.get(x) <3  && a <3) {
                        syllable.add(sentence.substring(0,((vowelIndex.get(x))+1)));
                        //System.out.println(syllable.get(0) + " 1 ilk hece");
                   }
                    if (vowelIndex.get(x) <3 && a==3) {
                        syllable.add(sentence.substring(0, (vowelIndex.get(x+1) -1)));
                       // System.out.println(syllable.get(0) + " 2 ilk hece");
                    }
                    if (vowelIndex.get(x) <3 && a==4) {
                        syllable.add(sentence.substring(0, (vowelIndex.get(x) + 3)));
                       // System.out.println(syllable.get(0) + "3  ilk hece");
                    }


                    //ilk hece bitti
                    //GÖVDE Hesabı
                    //b yi tanımlamalı
                    if ((x - 1 >= 0)) {
                        int b = (vowelIndex.get(x)) - (vowelIndex.get((x - 1)));
                        //System.out.println(b + " önce");

                        if (b == 1 && a <3&&x>0) {
                            syllable.add(sentence.substring(vowelIndex.get(x)));
                           // System.out.println(syllable.get(1) + " 1");
                        }
                        if (b == 1 && a >=3&&x>0) {
                            syllable.add(sentence.substring(vowelIndex.get(x),((vowelIndex.get(x+1))-1)));
                            //System.out.println(syllable.get(1) + " 2");
                        }
                        if (b >1 && a <3&&x>0) {
                            syllable.add(sentence.substring(((vowelIndex.get(x))-1),(vowelIndex.get(x)+1)));
                            //System.out.println(syllable.get(1) + " 3");
                        }
                        if (b >1 && a >=3&&x>0) {
                            syllable.add(sentence.substring(((vowelIndex.get(x))-1),((vowelIndex.get(x+1))-1)));
                           // System.out.println(syllable.get(1) + " 4");
                        }
//GÖVDE Hesabı bitti




                    }





                }
                if(x==(vowelIndex.size()-1)) {
                    if ((x - 1 >= 0)) {
                        int b = (vowelIndex.get(x)) - (vowelIndex.get((x - 1)));
                       // System.out.println(b + " önce");
                        //System.out.println("seni bekliyor");
                        if (b == 1) {
                            syllable.add(sentence.substring((vowelIndex.get(x)), sentence.length()));
                        }
                        if (b > 1) {
                            syllable.add(sentence.substring(((vowelIndex.get(x) - 1)), sentence.length()));
                        }
                    }
                }
            }
        }
     for(int x=0;x<syllable.size();x++){
         System.out.println(syllable.get(x)+" "+x);
     }
       // System.out.println(vowelIndex.size());
      //  System.out.println(syllable.size());
    }
}





