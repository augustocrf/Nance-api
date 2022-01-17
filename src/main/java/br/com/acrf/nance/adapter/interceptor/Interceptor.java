package br.com.acrf.nance.adapter.interceptor;

import br.com.acrf.nance.adapter.annotation.AllowAnnonymous;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getRequestURI().contains("api/v1")) {

            final AllowAnnonymous allowAnnonymous = ((HandlerMethod) handler).getMethod().getAnnotation((AllowAnnonymous.class));

            if (allowAnnonymous != null) {
                response.addHeader("Interceptor", "Allow Annonymous");
                log.info("Allow Annonymous.");
                return true;
            }

            if (request.getHeader("api-key") == null) {
                response.addHeader("Interceptor", "Autorização não enviado");
                response.setStatus(401);
                log.info("Autorização não enviado.");
                log.info("Validação NOK.");
                return false;
            } else if (request.getHeader("api-key").equals("aXRhw7o=")) {
                response.addHeader("Interceptor", "Authorization OK");
                log.info("Validação OK.");
                return true;
            } else {
                response.addHeader("Interceptor", "Authorization NOK");
                response.setStatus(401);
                log.info("Validação NOK.");
                return false;
            }
        } else { return true; }
    }
}
