package work.variety.hc_infos.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import work.variety.hc_infos.entity.Info;
import work.variety.hc_infos.entity.InfoCategoryEnum;
import work.variety.hc_infos.entity.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@WebAppConfiguration
public class InfoServiceTests {

    @Autowired
    private InfoService infoService;
    @Autowired
    private UserService userService;

    @Test
    public void createOneTest() {
        User user = userService.create("123", "weixinid", "13112341234", 3, 1, 1801);
        Info info = infoService.createOne(user, "test", "this is a test info", InfoCategoryEnum.REQUEST);
        System.out.println(info);
        Assert.assertEquals(info.getTitle(), "test");
        Assert.assertEquals(info.isRequest(), true);
    }

    @Test
    public void findOneTest() {
        User user = userService.create("123", "weixinid", "13112341234", 3, 1, 1801);
        Info info = infoService.createOne(user, "test", "this is a test info", InfoCategoryEnum.REQUEST);
        Assert.assertEquals(info.getTitle(), infoService.findOne(info.getId()).getTitle());
    }

    @Test
    public void findByTitleTest() {
        User user = userService.create("123", "weixinid", "13112341234", 3, 1, 1801);
        infoService.createOne(user, "test", "this is a test info", InfoCategoryEnum.REQUEST);
        infoService.createOne(user, "test1", "this is a test info", InfoCategoryEnum.REQUEST);
        infoService.createOne(user, "test2", "this is a test info", InfoCategoryEnum.REQUEST);
        infoService.createOne(user, "test3", "this is a test info", InfoCategoryEnum.REQUEST);
        Page<Info> page = infoService.findByTitle("test", 0);
        System.out.println(page.getTotalElements());
        System.out.println(page.getContent());
    }

    @Test
    public void findAll() {
        User user = userService.create("123", "weixinid", "13112341234", 3, 1, 1801);
        infoService.createOne(user, "test", "this is a test info", InfoCategoryEnum.REQUEST);
        infoService.createOne(user, "test1", "this is a test info", InfoCategoryEnum.REQUEST);
        infoService.createOne(user, "test2", "this is a test info", InfoCategoryEnum.REQUEST);
        infoService.createOne(user, "test3", "this is a test info", InfoCategoryEnum.REQUEST);

        Page<Info> page = infoService.findAll(0);
        System.out.println("=====>");
        System.out.println(page.getContent().size());
        System.out.println(page.getTotalPages());
        System.out.println(page);
    }

}
