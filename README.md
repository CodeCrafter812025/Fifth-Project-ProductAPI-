# 🚀 پروژه [ProductAPI]  

یک پروژه Backend توسعه‌یافته با **Spring Boot** و معماری چندلایه، طراحی شده 

## 🔧 فناوری‌های استفاده شده  
- **زبان اصلی**: Java 17+  
- **فریم‌ورک**: Spring Boot 3.x  
- **پایگاه داده**: MySQL  
- **ابزارهای توسعه**:  
  - Spring Data JPA (برای لایه دسترسی به داده)    
  - Lombok (برای کاهش Boilerplate Code)  
  - ModelMapper (برای مپینگ DTOها)
    
   
## 🏗️ معماری پروژه  
پروژه به صورت **ماژولار** و با **معماری چندلایه** طراحی شده است: 
project/
├── module-doc/ # درج اطلاعات در پایگاه داده
├── module-api/ # لایه کنترلر و REST APIها
├── module-service/ # لایه کسب‌وکار و منطق برنامه
├── module-dataaccess/ # لایه دسترسی به داده (JPA/Hibernate)
└── module-common/ # تنظیمات امنیتی 


