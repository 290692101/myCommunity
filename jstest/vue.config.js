module.exports = {
    devServer: {
        disableHostCheck: false,
        host: "127.0.0.1",
        port: 7777,
        https: false,
        hotOnly: false,
        // proxy: null
        proxy: {
            "/api": {
                target: "http://127.0.0.1:8080", // 要访问的接口域名
                ws: true, // 是否启用websockets
                changeOrigin: true, //开启代理：在本地会创建一个虚拟服务端，然后发送请求的数据，并同时接收请求的数据，这样服务端和服务端进行数据的交互就不会有跨域问题
                pathRewrite: {
                    //'^/api': '/api'   // 这种接口配置出来     http://XX.XX.XX.XX:8083/api/login
                    '^/api': '/' //这种接口配置出来     http://XX.XX.XX.XX:8083/login
                }

            }
        }

}

};
