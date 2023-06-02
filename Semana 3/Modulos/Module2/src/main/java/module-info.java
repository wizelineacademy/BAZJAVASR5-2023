import com.wizeline.module2.services.HelloService;

module com.wizeline.module2 {
    requires com.wizeline.module1;

    exports com.wizeline.module2.interfaces;

    provides com.wizeline.module2.interfaces.HelloInterface
            with HelloService;
}