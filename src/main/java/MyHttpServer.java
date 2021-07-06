import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;

public class MyHttpServer extends AbstractVerticle {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MyHttpServer());
    }

    @Override
    public void start() {
        Vertx vertx = this.vertx;
        vertx.createHttpServer()
                .requestHandler(request -> {
                    // 获取到response对象
                    HttpServerResponse response = request.response();

                    // 设置响应头
                    response.putHeader("Content-type", "text/html;charset=utf-8");

                    // 响应数据
                    response.end("Hello World");
                })
                .listen(8888);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

}
