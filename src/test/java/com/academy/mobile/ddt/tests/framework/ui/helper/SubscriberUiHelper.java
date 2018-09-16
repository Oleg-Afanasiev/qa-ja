package com.academy.mobile.ddt.tests.framework.ui.helper;

import com.academy.mobile.ddt.tests.framework.model.Entities;
import com.academy.mobile.ddt.tests.framework.model.Gender;
import com.academy.mobile.ddt.tests.framework.model.Subscriber;
import com.academy.mobile.ddt.tests.framework.ui.page.SubscriberPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.academy.util.MatcherAssertExt.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class SubscriberUiHelper extends BaseUiHelper {

    public SubscriberUiHelper(WebDriver driver) {
        super(driver);
    }

    public Entities<Subscriber> all() {
        SubscriberPage subscriberPage = new SubscriberPage(driver);
        List<Long> idList = subscriberPage.getIdList();
        List<String> firstNameList = subscriberPage.getFirstNameList();
        List<String> lastNameList = subscriberPage.getLastNameList();
        List<Gender> genderList = subscriberPage.getGenderList();
        List<Integer> ageList = subscriberPage.getAgeList();

        Entities<Subscriber> subscribers = new Entities<>();
        for (int i = 0; i < idList.size(); i++) {
            Subscriber subscriber = new Subscriber();
            subscriber.setId(idList.get(i));
            subscriber.setFirstName(firstNameList.get(i));
            subscriber.setLastName(lastNameList.get(i));
            subscriber.setGender(genderList.get(i));
            subscriber.setAge(ageList.get(i));

            subscribers.add(subscriber);
        }

        return subscribers;
    }

    public void verifyIfOnEqualTo(Entities<Subscriber> expected) {
        if (isOn) {
            assertThat(all(), equalTo(expected));
        }
    }
}
