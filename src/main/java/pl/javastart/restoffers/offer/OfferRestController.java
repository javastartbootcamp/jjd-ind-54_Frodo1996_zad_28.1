package pl.javastart.restoffers.offer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offers")
public class OfferRestController {

    private final OfferService offerService;

    public OfferRestController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/count")
    public long countOffers() {
        return offerService.count();
    }

    @GetMapping
    public List<OfferDto> findByTitle(@RequestParam(required = false) String title) {
        if (title != null && !title.isEmpty()) {
            return offerService.findByTitle(title);
        } else {
            return offerService.findAll();
        }
    }

    @PostMapping("")
    @ResponseBody
    public OfferDto saveOffer(@RequestBody OfferDto dto) {
        return offerService.saveOffer(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        offerService.deleteById(id);

    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDto> findById(@PathVariable Long id) {
        Optional<OfferDto> taskOptional = offerService.findById(id);
        return taskOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}