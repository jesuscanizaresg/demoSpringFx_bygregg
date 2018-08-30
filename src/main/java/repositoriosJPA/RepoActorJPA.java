package repositoriosJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entidades.Actor;

public interface RepoActorJPA extends JpaRepository <Actor, Integer> {

}
