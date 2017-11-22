package work.variety.hc_infos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import work.variety.hc_infos.dao.InfoRepository;
import work.variety.hc_infos.entity.Info;
import work.variety.hc_infos.entity.InfoCategoryEnum;
import work.variety.hc_infos.entity.InfoStatusEnum;
import work.variety.hc_infos.entity.User;

import java.util.List;

@Service
public class InfoService {

    @Value("${work.variety.pageSize}")
    private int pageSize;

    @Autowired
    private InfoRepository infoRepository;

    public Info createOne(User user, String title, String description, InfoCategoryEnum categoryEnum){
        Info info = new Info(user, title, description, categoryEnum);
        return infoRepository.save(info);
    }

    public Info findOne(Long id){
        return infoRepository.findOne(id);
    }

    public List<Info> indexInfos(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(0, 59, sort);
        return infoRepository.findTop59ByStatus(InfoStatusEnum.ACTIVE.getStatus());
    }

    public Page<Info> findAll(int page){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, pageSize, sort);
        return infoRepository.findByStatus(InfoStatusEnum.ACTIVE.getStatus(), pageable);
    }

    public Page<Info> findByTitle(String title, int page){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, pageSize, sort);
        return infoRepository.findTop10ByStatusAndTitleContaining(InfoStatusEnum.ACTIVE.getStatus(), title, pageable);
    }
}
