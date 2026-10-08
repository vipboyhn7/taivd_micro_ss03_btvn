# Order Service

Order Service quản lý đơn hàng và sở hữu database `order_db` độc lập.

## Chạy project

Yêu cầu:

- Java 17+
- Maven 3.9+
- PostgreSQL
- Product Service đang chạy ở port `8082`

Tạo database:

```sql
CREATE DATABASE order_db;
```

Chạy ứng dụng:

```bash
mvn spring-boot:run
```

Service chạy tại `http://localhost:8083`.

Mặc định Order Service lấy giá sản phẩm từ:

```text
http://localhost:8082/api/v1/products/{id}
```

Có thể thay đổi URL bằng biến môi trường `PRODUCT_SERVICE_URL`.

## API

### Tạo đơn hàng

```http
POST http://localhost:8083/api/v1/orders
Content-Type: application/json
```

```json
{
  "customerId": 1,
  "productId": 1,
  "quantity": 2
}
```

`quantity` phải lớn hơn `0`. `totalAmount` được tính bằng `price * quantity`.

### Lấy đơn hàng

```http
GET http://localhost:8083/api/v1/orders/1
```

Order Service chỉ lưu `customerId` và `productId` dưới dạng số, không dùng `@ManyToOne`, `@OneToOne` hoặc `@JoinColumn` đến database khác.
