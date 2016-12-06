__TOC__

هدف از این پروژه آشنا ساختن برنامه نویسان جدید با امکانات وایز است. در این تمرین یک دفترچه تماس (Contact List) کوچک و ساده تولید می شود. در این تمرین از فناوری های زیر استفاده می شود:
*Spring Framework
*Hibernate برای کار با پایگاه داده
*JAX-RS برای تولید سرویسهای REST
*AngularJS و Bootstrap‌ برای تولید واسط کاربر
*LogBack‌ و SLF4J برای درج لاگ
*JUnit برای تست واحد

در ابتدا به معرفی کلی سیستم دفترچه تماس خواهیم پرداخت. سپس در چند گام این سیستم را پیاده سازی خواهیم کرد.

;روش انجام تمرین

*ابتدا بخش معرفی سیستم را کامل و دقیق مطالعه نمایید.
*سپس هر گام را مطالعه کنید و انجام دهید. بهتر است قبل از انجام یک مرحله، مرحله بعدی را مطالعه نکنید.
*پس از انجام هر مرحله آن را به مربی تحویل بدهید و ایرادات آن را بپرسید.

# معرفی سیستم
سیستم دفترچه تلفن باید قابلیت های زیر را داشته باشید.
*ثبت اطلاعات تماس یک شخص جدید شامل نام، آدرس، تلفن منزل، تلفن همراه، آدرس ایمیل و ...
*مشاهده لیست اطلاعات تماس موجود
*ویرایش اطلاعات تماس
*حذف اطلاعات تماس

فرمها باید به گونه ای طراحی شوند که روی اسکرینهای کوچک مثل صفحات گوشی های هوشمند به خوبی دیده شوند. 

# پیش نیازها
قبل از شروع این دستورالعمل با راهنمایی معین خود موارد زیر را آماده کنید.
*پکیج نصب JDK نسخه 1.8.x ([لینک دانلود](http://ghaffarian.net/downloads/Java/))
*پکیج Eclipse. بهتر است از بسته eclipse سفارشی سازی شده برای وایز تحت عنوان wiclipse استفاده نمایید. توجه کنید که eclipse و jdk باید هر دو 64 بیتی یا هر دو 32 بیتی باشند. ([لینک دانلود](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/neon1a)). لازم به توضیح است امکان استفاده از Intellij Idea یا Netbeans به جای Eclipse وجود دارد ولی این مستند مبتنی بر Eclipse توضیح داده شده است.
*پکیج apache-tomcat-8.x  ([لینک دانلود](http://tomcat.apache.org/download-80.cgi))
*maven برای دریافت کتایخانه های مورد نیاز ([لینک دانلود](http://maven.apache.org/download.cgi))
*[Postman](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop) روی [مرورگر chrome](https://www.google.com/chrome/browser/desktop/index.html) برای تست سرویسهای REST

# آماده سازی محیط
;آماده سازی jdk
*JDK (دقت داشته باشید JDK و نه JRE) را روی دستگاه خود نصب نمایید.
*متغیر محیطی JAVA_HOME در سیستم عامل خود تنظیم نمایید به شکلی که به مسیر JDK اشاره کند. [روش تنظیم متغیر محیطی در ویندوز](http://www.computerhope.com/issues/ch000549.htm). مثال:
<pre style="direction: ltr;">JAVA_HOME="C:\Program Files\Java\jdk8"</pre>
;آماده سازی maven
*پکیج maven را در مسیر دلخواه باز کنید. 
*متغیر محیطی M2_HOME رادر سیستم  عامل خود تنظیم نمایید به شکلی که به مسیر فوق اشاره کند. مثلاً
<pre style="direction: ltr">CATALINA_HOME=C:\wise\apache-maven</pre>
;آماده سازی tomcat
*پکیج tomcat در مسیر دلخواهی که فاقد کارکترهای خاص باشد باز کنید. 
*متغیر محیطی CATALINA_HOME در سیستم عامل خود تنظیم نمایید به شکلی که به مسیر فوق اشاره کند. مثلا :
<pre style="direction: ltr">CATALINA_HOME=C:\wise\apache-tomcat</pre>

;آماده سازی Eclipse
*پکیج Eclipse را در مسیر دلخواه خود مثلاً c:\wise\wiclipse باز کنید. 
*با اجرای Eclipse.exe وارد محیط برنامه نویسی Eclipse بشوید.
*برای تنظیم jdk در eclipse‌ اقدامات زیر را انجام دهید:
    *در Eclipse به منوی «Window > Preferences» را اجرا نمایید.
    *در درخت تنظیمات به قسمت «Java/Installed JREs» بروید.
    *با زدن دکمه Add مسیر JDK ای که نصب کرده اید را وارد کنید و یک JDK جدید تعریف نمایید. (مجددا تأکید می شود JDK‌ و نه JRE)
    *این JDK جدید را با زدن تیک کنار نام آن به عنوان پیش فرض انتخاب کنید.
    *سایر JRE هایی که از قبل در فرم تعریف شده اند را پاک کنید.

# دریافت پروژه از Git
برای آنکه در شروع کار درگیر پیکربندی کتابخانه ها نشوید اسکت بندی پروژه دفترچه تماس قبلا آماده شده است. برای دریافت آن از Git به [این آدرس](https://git.asta.ir/open/ir.asta.training.contacts) مراجعه نمایید.

پس از دریافت پروژه فایلهای زیر را یک بار مرور کنید:
*pom.xml
*web.xml
*applicationContext-base.xml
*Contact.hbm.xml
*ContactEntity.java
*ContactDao.java
*ContactManager.java
*ContactService.java
*ContactServiceImpl.java
غیر از کلاسها و فایل Contact.hbm.xml لازم نیست در این مرحله از سایر فایلها به طور کامل سر در بیاورید. 

# اتصال تامکت به پایگاه داده

*ابتدا فایل jar مربوط به درایور پایگاه داده h2 را از شاخه lib در پروژه ir.asta.wise.contacts ‌در شاخه lib تامکت کپی کنید.
*اتصال به پایگاه داده h2 را در فایل context.xml در شاخه conf تامکت به شکل زیر تعریف کنید:
<syntaxhighlight lang=xml highlight=7-12>
<?xml version="1.0" encoding="UTF-8"?>
<Context>

    <WatchedResource>WEB-INF/web.xml</WatchedResource>
    <WatchedResource>${catalina.base}/conf/web.xml</WatchedResource>
	
	<Resource name="jdbc/contactdb" auth="Container"
		type="javax.sql.DataSource" driverClassName="org.h2.Driver"
		url="jdbc:h2:~/.h2db"
		username="wise" password="wise" 
		maxActive="50" maxIdle="10"  maxWait="-1"
		poolPreparedStatements="true"/>
</Context>

</syntaxhighlight>


# اجرای برنامه
*برای نصب برنامه در تامکت اقدامات زیر را انجام بدهید:
    *در Eclipse با مراجعه به منوی «Window/Show View»، پنجره Ant View را اضافه کنید.
    *فایل Build.xml را از پروژه ir.asta.wise.spl به Ant View خود در Eclipse اضافه کنید. 
    *از درخت دستوراتی که در Ant View مشاهده می کنید دستور contacts/tomcat-deploy را اجرا کنید. 
    *به شاخه webapps در تامکت خود مراجعه کنید. باید یک شاخه به نام contacts در آن به وجود آمده باشد.
*برای اجرای برنامه در eclipse روی فایل ir.asta.training.contacts/WISE-Tomcat-8.launch کلیک راست کنید و از منو Run as/WISE-Tomcat-8 را انتخاب نمایید.
*در مرورگر آدرس http://localhost:8080/contacts/index.jsp‌ را بزنید.
'''نکته:''' در صورتی که پرت 8080 یا 8009 سیستم شما قبلا به وسیله یک پردازه دیگر اشغال شده باشد با خطای JVM Bind مواجه خواهید شد. در این صورت می توانید شماره پرتهای تامکت را در فایل conf/server.xml در تامکت تغییر بدهید.

# تست سرویس آزمایشی
دو سرویس REST آزمایشی در آدرس زیر قرار دارند. پس از اجرای برنامه آنها را با استفاده از Postman اجرا و خروجی آنها را مشاهده نمایید. لازم به توضیح است پیاده سازی سرویس load واقعی نیست و یک خروجی فرضی بر می گردانند.
;سرویس ذخیره سازی آدرس تماس: با فراخوانی این سرویس یک رکورد در جدول WISE_CONTACT درج می شود. این جدول فعلا فقط دو ستون contact_id و name دارد. این سرویس پس از ذخیره سازی یک پیغام موفقیت و شناسه رکورد ذخیره شده با بر می گرداند.  
<center>
[Contacts Postman1.png]([پرونده:Training)]
</center>
;سرویس load آدرس تماس
<center>
[Contacts Postman2.png]([پرونده:Training)]
</center>

# پیاده سازی سه سرویس REST
در این مرحله می خواهیم سه سرویس REST برای قابلیتهای زیر بنویسیم:
*save‌ کردن contact 
*load کردن contact 
*لیست کردن تمام contact های موجود

;مراحل انجام کار:
*با اتکا به دانش hibernate خود کلاس ContactEntity و فایل Contact.hbm.xml را در پروژه ir.asta.training.contacts‌ تکمیل کنید به گونه ای که فیلدهای ذکر شده در قسمت معرفی سیستم را پوشش دهد. 
*در کلاس ContactDao‌ پیاده سازی متدهای load و findAll را با الهام از پیاده سازی متد save کامل کنید. 
*در کلاس ContactManager پیاده سازی متدهای load و findAll را با الهام از پیاده سازی متد save و با کمک فیلد dao (از نوع ContactDao) تکمیل نمایید. 
*با اتکا به دانش JAX-RS خود در کلاس ContactServiceImpl پیاده سازی متد load را با الهام از پیاده سازی متد save و با کمک فیلد manager (از نوع ContactManager) تکمیل نمایید. 
*سرویس findAll را به واسط ContactService اضافه نمایید. این سرویس REST را در کلاس ContactServiceImpl پیاده سازی نمایید. 
*برنامه را مثل قبل اجرا کنید و با کمک Postman سرویسهایی که ایجاد کرده اید را تست کنید.
