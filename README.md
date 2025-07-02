# 📦 Enocta Case Study - UI & API Automation Project

Bu proje, Enocta şirketi için hazırlanan bir UI ve API test otomasyonu case çalışmasıdır.  
Hepsiburada sitesi baz alınarak test senaryoları oluşturulmuş ve Cucumber + TestNG framework’ü kullanılarak otomasyon gerçekleştirilmiştir.

---

## 🚀 Kullanılan Teknolojiler

- 🧪 **Test Framework:** Cucumber (BDD) + TestNG  
- 🌐 **UI Testleri:** Selenium WebDriver  
- ⚙️ **Build Tool:** Maven  
- 💻 **IDE:** IntelliJ IDEA  
- 🔧 **API Testleri:** Postman  
- 📸 **Screenshot:** Senaryo hatasında ekran görüntüsü alma  

---

## 📁 Proje Yapısı

src/
├── test/
│ ├── java/
│ │ ├── pages/ # Sayfa sınıfları (Page Object Model)
│ │ ├── stepDefinitions/ # Cucumber adım tanımları
│ │ ├── runners/ # Test runner dosyaları
│ │ └── utilities/ # Driver, ConfigReader, ReusableMethods vb.
│ └── resources/
│ ├── features/ # .feature dosyaları
│ ├── n11_data/ # Test verileri (opsiyonel)
│ └── config.properties # Test ayarları


---

## 🧪 UI Test Senaryosu

**Feature:** Sepete Ürün Ekleme  
Kullanıcı farklı ürünleri arayıp filtre uygular, ürünü sepete ekler ve sepette doğrulama yapar.

📌 **Senaryo Adımları:**
1. ✅ Kullanıcı giriş yapar  
2. 🔍 Belirtilen kelime ile ürün araması yapar  
3. 💰 Fiyat aralığı filtresi uygular  
4. 🛍 İstenen sıradaki ürünü seçer  
5. 🏪 Satıcı stratejisine göre seçim yapılır  
6. 🧺 Ürün sepete eklenir  
7. 📦 Sepette doğrulama yapılır  

---

## 🖼 Hata Durumunda Ekran Görüntüsü (Bonus)

Senaryo başarısız olursa, otomatik olarak ekran görüntüsü alınır ve `Cucumber Report`'a eklenir.

📁 Ekran görüntüsü rapora gömülüdür:  
- `scenario.attach(screenshot, "image/png", "screenshot-on-failure")`

---

## 🔄 Projeyi Çalıştırma

1. ✅ IntelliJ ile projeyi aç  
2. 🛠 `config.properties` dosyasındaki URL ve tarayıcı ayarlarını yap  
3. ▶️ `TestRunner.java` dosyasını çalıştır  
4. 📊 Raporlar `target/cucumber-reports.html` altında oluşur

---

## 📬 API Testleri

Postman kullanılarak mock server üzerinden örnek testler yazıldı.  
Collection ve environment dosyaları `Invoice.postman_collection.json dosyasından ` klasörüne eklenmiştir.

## Postman Mock Server Hakkında

Bu projede API testleri için **Postman Mock Server** kullanılmıştır. Mock Server, gerçek backend servisi olmadan API çağrılarına önceden tanımlanmış cevaplar vererek test sürecini kolaylaştırır.

### Koleksiyon İçeriği

- **token**: Kullanıcı adı ve şifre ile POST isteği yapılarak token alınır.
- **viewInvoice**: GET isteği ile verilen barkod numarasına ait fatura bilgisi alınır.
- **sendInvoice**: Token ile yetkilendirilmiş POST isteği ile fatura gönderimi yapılır.

 ---

### 👩‍💻 Geliştirici

- **Ad:** Hercai Şevval Erdem  
- 📧 `hercaierdem27@gmail.com`  
- 💼 [LinkedIn](https://www.linkedin.com/in/hercaierdem/)  

---

> Bu proje, bir iş başvurusu case çalışması kapsamında hazırlanmıştır.
