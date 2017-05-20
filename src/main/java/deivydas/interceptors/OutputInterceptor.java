package deivydas.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
/**
 * Created by Simas.Lukenas on 2017-05-16.
 */
@DeivydoInterceptor
@Interceptor
public class OutputInterceptor implements Serializable {
    @AroundInvoke
    public Object doSomeStuff(InvocationContext ctx) throws Exception{
        System.out.println("Kvieciama funkcija: " + ctx.getMethod().toString());
        Object result = ctx.proceed();
        if (result != null)
            System.out.println("Gautas objektas: " + result.toString());
        return result;
    }
}