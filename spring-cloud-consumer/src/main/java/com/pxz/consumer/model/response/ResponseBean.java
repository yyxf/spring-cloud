package com.pxz.consumer.model.response;

/**
 * @author YangSheng
 * @Package com.qckj.core.response
 * @date 2018/10/19 15:27
 */
public class ResponseBean<T> {
    /**返回状态码，建议使用StatusCode中定义的**/
    int code;

    /**返回信息**/
    String msg;

    /**返回数据集**/
    T data;


    public ResponseBean(){
        this.setCode(StatusCode.SUCCESS.getCode());
        this.setMsg(StatusCode.SUCCESS.getMsg());
    }

    public ResponseBean success(){
        this.setCode(StatusCode.SUCCESS.getCode());
        this.setMsg(StatusCode.SUCCESS.getMsg());
        return this;
    }


    public ResponseBean success(String msg){
        this.setCode(StatusCode.SUCCESS.getCode());
        this.setMsg(msg);
        return this;
    }

    public ResponseBean error(){
        this.setCode(StatusCode.ERROR.getCode());
        this.setMsg(StatusCode.ERROR.getMsg());
        return this;
    }

    public ResponseBean error(String msg){
        this.setCode(StatusCode.ERROR.getCode());
        this.setMsg(msg);
        return this;
    }


    public ResponseBean paramError(String param){
        this.setCode(StatusCode.PARAM_ERROR.getCode());
        this.setMsg(String.format("Parameter error: %s", param));
        return this;
    }

    /**
     * @comments: 找不到数据或数据为空时返回。
     * @param
     * @return zh.Beans.result.ResponseBean
     * @throws
     * @author 杨盛
     * @date 2018-08-01 16:00
     */
    public ResponseBean notFound(){
        this.setCode(StatusCode.NOT_FOUND.getCode());
        this.setMsg(StatusCode.NOT_FOUND.getMsg());
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResponseBean setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseBean setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
