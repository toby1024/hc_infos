package work.variety.hc_infos.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import work.variety.hc_infos.entity.Info;
import work.variety.hc_infos.entity.User;

import java.util.List;

public interface InfoRepository extends PagingAndSortingRepository<Info, Long> {

    public Page<Info> findTop10ByStatusAndTitleContaining(int status, String title, Pageable pageable);

    public List<Info> findTop59ByStatus(int status);

    Page<Info> findByStatus(int status, Pageable pageable);

    Page<Info> findByStatusAndUser(int status, User user, Pageable pageable);
}
