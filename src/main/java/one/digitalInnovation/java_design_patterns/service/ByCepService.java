package one.digitalInnovation.java_design_patterns.service;

import one.digitalInnovation.java_design_patterns.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ByCepService {

    @GetMapping("/{cep}/json/")
    Address checkCep(@PathVariable("cep") String cep);
}
