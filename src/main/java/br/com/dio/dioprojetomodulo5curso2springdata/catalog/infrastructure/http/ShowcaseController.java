package br.com.dio.dioprojetomodulo5curso2springdata.catalog.infrastructure.http;

import br.com.dio.dioprojetomodulo5curso2springdata.catalog.application.BrowserShowcaseUseCase;
import br.com.dio.dioprojetomodulo5curso2springdata.catalog.application.dto.EventOutput;
import br.com.dio.dioprojetomodulo5curso2springdata.catalog.domain.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/showcase")
public class ShowcaseController {

    private final BrowserShowcaseUseCase browserShowcaseUseCase;


    public ShowcaseController(BrowserShowcaseUseCase browserShowcaseUseCase) {
        this.browserShowcaseUseCase = browserShowcaseUseCase;
    }

    @GetMapping
    List<EventOutput> browserShowcase() {
        return browserShowcaseUseCase.execute();
    }
}
