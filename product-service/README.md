# Product Service

Product Service quản lý sản phẩm và tồn kho trong hệ thống thương mại điện tử.

## Chạy project

Yêu cầu:

- Java 17+
- Maven 3.9+
- PostgreSQL

Tạo database:

```sql
CREATE DATABASE product_db;
```

Chạy ứng dụng:

```bash
mvn spring-boot:run
```

Service chạy tại `http://localhost:8082`.

## API

### Tạo sản phẩm

```http
POST http://localhost:8082/api/v1/products
Content-Type: application/json
```

```json
{
  "name": "Keyboard",
  "price": 300000,
  "stockQuantity": 10
}
```

`name` không được để trống, `price` phải lớn hơn `0`, `stockQuantity` không được âm.

### Lấy sản phẩm theo ID

```http
GET http://localhost:8082/api/v1/products/1
```

### Lấy toàn bộ sản phẩm

```http
GET http://localhost:8082/api/v1/products
```
