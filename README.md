
# Fifth Project - Product API 🛒

پروژه‌ای تمرینی برای ساخت یک RESTful API با استفاده از Java و Spring Boot جهت مدیریت محصولات.

## 🔧 تکنولوژی‌ها و ابزارها
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security + JWT
- MySQL
- Maven

## 📦 نحوه اجرا (Run)
1. پروژه را کلون کنید:
   ```bash
   git clone https://github.com/CodeCrafter812025/Fifth-Project-ProductAPI-.git
   ```
2. وارد دایرکتوری پروژه شوید:
   ```bash
   cd Fifth-Project-ProductAPI-
   ```
3. فایل `application.properties` را با مشخصات دیتابیس خودتان تنظیم کنید:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/product_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   jwt.secret=your_jwt_secret
   ```

4. اجرای پروژه با Maven:
   ```bash
   mvn spring-boot:run
   ```

## ✅ ویژگی‌ها (Features)
- ثبت، ویرایش، حذف و مشاهده محصولات
- احراز هویت کاربران با JWT
- محافظت از مسیرها با نقش‌ها
- استفاده از JPA برای ارتباط با دیتابیس MySQL
- مستندسازی REST API (در صورت استفاده از Swagger)

## 🛡️ امنیت
- استفاده از JWT برای صدور و بررسی توکن دسترسی
- محافظت از endpointها با نقش‌های کاربری

## 📁 ساختار پروژه
```
src/
 └── main/
     ├── java/
     │   └── com/example/productapi/
     ├── resources/
     │   ├── application.properties
     │   └── ...
```

## ✍️ توسعه‌دهنده
[CodeCrafter812025](https://github.com/CodeCrafter812025)
