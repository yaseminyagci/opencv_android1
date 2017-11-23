# opencv_android1
opencv kütüphanesi yüklendi ve kamera açıldı.

opencv android sdk 2.4.9 verisyonu indirildi.
Yeni proje açılarak import module denildikten sonra opencv kütüphanesinden sdk->java seçilir.
project structure->app->dependencies-> + ->add module ->opencv seçilir
file->new -> folder->jni folder  folder eklendikten sonra opencv kütüphanesinden native deki libs'deki bütün dosyalar 
kopyalanarak yeni oluşturulan jni kütüphane folderının içine konur. Folder ı project yaparak app->src->main altında bulabiliriz.
Ekledikten sonra opencv ve gradle daki sdklrın aynı olmasına dikkat edelim. 
örn : compileSdkVersion 26
      buildToolsVersion "26.0.2"
gradle.properties 'in sonuna  android.useDeprecatedNdk=true yazalım.
Main activity içine de 
 private static final String TAG="MainActivity";
 static{
 if (OpenCVLoader.initDebug()) {
                Log.i(TAG, "static initializer: success");
           


            }else {
                Log.i(TAG, "static initializer: couldnt success");}
                
logta yüklenip yüklenmediğine bakalım. Bende yüklenmedi yazdı fakat kodlar çalışmaktaydı :/ 
Yüklendi varsaydım :)
