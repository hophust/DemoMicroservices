Một bộ khung cho hệ thống Microservices tối thiểu cần một service discovery (service registry) (eureka server), các service con và một gateway service.

Eureka: Đây là một máy chủ dùng để quản lý, đặt tên cho các service, hay còn gọi là service registry. Mỗi service sẽ được đăng ký với Eureka và sẽ ping cho Eureka để đảm bảo chúng vẫn hoạt động. Nếu Eureka server không nhận được bất kỳ thông báo nào từ service thì service đó sẽ bị gỡ khỏi Eureka một cách tự động. 

Gateway Service: Nó là một proxy, gateway và một lớp trung gian giữa user và các service của bạn. Eureka server đã giải quyết vấn đề đặt tên cho từng service thay vì dùng địa chỉ IP của chúng. 

Image Service: Nó như một nguồn để chứa và cung cấp các bức ảnh, mỗi bức ảnh sẽ có id, title và địa chỉ url.

Gallery Service: Nó sẽ gọi đến image service thông qua các endpoint mà chúng ta đã tạo ra ở trên, và từ đó sẽ get ra một list ảnh để tạo ra một album. Bây giờ, ta sẽ áp dụng các bước triển khai để xây dựng hệ thống Microservices như trên
