package com.landmark.app;

import com.landmark.app.model.dto.TourReviewDTO;
import com.landmark.app.service.TourReviewService;
import com.landmark.app.utils.constants.Constants;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import static com.landmark.app.utils.constants.Constants.ROLE_ADMIN;
import static com.landmark.app.utils.constants.Constants.ROLE_USER;

@SpringBootTest
public class TourReviewServiceTests {

    private TourReviewService tourReviewService;

    @Autowired
    public TourReviewServiceTests(TourReviewService tourReviewService) {
        this.tourReviewService = tourReviewService;
    }

    @Test
    @Ignore
    public void getRecentReviewsTest() {
        int userId = 2;
        System.out.println(tourReviewService.getRecentReviews(userId));
    }

    @Test
    @Ignore
    public void countByAreaCodeTest() {
        int userId = 2;
        int areaCode = 31;
        System.out.println(Constants.areaCodeMap.get(areaCode) + " : " + tourReviewService.countByAreaCode(areaCode, userId));
    }

    @Test
    public void registerReviewTest() {
        try {
            TourReviewDTO tourReviewDTO = new TourReviewDTO();
            tourReviewDTO.setAreaCode(31);
            tourReviewDTO.setSigunguCode(9);
            tourReviewDTO.setTitle("바나나보트");
            tourReviewDTO.setUserId(10);
            tourReviewDTO.setTourId(3);
            tourReviewDTO.setPrivate(true);
            System.out.println(tourReviewService.registerReview(tourReviewDTO).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Ignore
    public void getReviewListTest() {
        TourReviewDTO.SearchReviewDTO searchReviewDTO = new TourReviewDTO.SearchReviewDTO();
        searchReviewDTO.setPage(0);
        searchReviewDTO.setSize(10);

        int userId = 11;
        String roleName = ROLE_USER;

        System.out.println(tourReviewService.getReviewList(userId, roleName, searchReviewDTO).getContent());
    }

}
