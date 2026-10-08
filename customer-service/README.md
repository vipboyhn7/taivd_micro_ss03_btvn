# Customer Service

Customer Service là service Spring Boot quản lý khách hàng trong hệ thống thương mại điện tử.

## Chạy project

Yêu cầu:

- Java 17+
- Maven 3.9+
- PostgreSQL

Tạo database:

```sql
CREATE DATABASE customer_db;
```

Chạy ứng dụng:

```bash
mvn spring-boot:run
```

Service chạy tại `http://localhost:8081`.

Có thể thay đổi thông tin kết nối bằng biến môi trường:

```bash
DB_URL=jdbc:postgresql://localhost:5432/customer_db \
DB_USERNAME=postgres \
DB_PASSWORD=postgres \
mvn spring-boot:run
```

## API

### Đăng ký

```http
POST http://localhost:8081/api/v1/customers/register
Content-Type: application/json
```

```json
{
  "fullName": "Nguyen Van A",
  "email": "a@example.com",
  "password": "secret123"
}
```

### Tìm theo ID

```http
GET http://localhost:8081/api/v1/customers/1
```

### Đăng nhập

```http
PUT http://localhost:8081/api/v1/customers/login
Content-Type: application/json
```

```json
{
  "email": "a@example.com",
  "password": "secret123"
}
```
