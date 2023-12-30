package pl.javastart.restoffers.offer;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferService {
    
    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public OfferDto saveOffer(OfferDto dto) {
        Offer offer = mapToEntity(dto);
        Offer savedOffer = offerRepository.save(offer);
        return mapToDto(savedOffer);
    }

    private Offer mapToEntity(OfferDto dto) {
        Offer offer = new Offer();
        offer.setTitle(dto.getTitle());
        offer.setDescription(dto.getDescription());
        offer.setImgUrl(dto.getImgUrl());
        offer.setPrice(dto.getPrice());
        return offer;
    }

    private OfferDto mapToDto(Offer offer) {
        OfferDto offerDto = new OfferDto();
        offerDto.setId(offer.getId());
        offerDto.setTitle(offer.getTitle());
        offerDto.setDescription(offer.getDescription());
        offerDto.setImgUrl(offer.getImgUrl());
        offerDto.setPrice(offer.getPrice());
        return offerDto;
    }

    public Optional<OfferDto> findById(Long id) {
        return offerRepository.findById(id)
                .map(this::toDto);
    }

    public long count() {
        return offerRepository.findAll().size();
    }

    public List<OfferDto> findByTitle(String partialTitle) {
        List<Offer> offers = offerRepository.findAll();

        List<Offer> filteredOffers = offers.stream()
                .filter(offer -> offer
                        .getTitle()
                        .toLowerCase()
                        .contains(partialTitle.toLowerCase()))
                .toList();

        return filteredOffers.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        try {
            offerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ignore) {
            throw new IllegalArgumentException("Wrong ID, try again!");
        }
    }

    private OfferDto toDto(Offer offer) {
        OfferDto dto = new OfferDto();
        dto.setId(offer.getId());
        dto.setTitle(offer.getTitle());
        dto.setDescription(offer.getDescription());
        dto.setPrice(offer.getPrice());
        dto.setCategoryName(offer.getCategory().getName());
        return dto;
    }

    public List<OfferDto> findAll() {
        return offerRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }
}