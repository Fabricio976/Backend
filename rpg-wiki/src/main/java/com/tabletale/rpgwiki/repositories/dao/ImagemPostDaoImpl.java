package com.tabletale.rpgwiki.repositories.dao;

import com.tabletale.rpgwiki.domain.entity.ImagemPost;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ImagemPostDaoImpl extends AbstractDao<ImagemPost, Long> implements ImagemPostDao {

    @Override
    public ImagemPost buscarImagemPost(String idPost) throws NoResultException {
        String jpql = "select i from ImagemPost i where i.personagem = (select p from Post p where p.id = '" + idPost + "')";
        TypedQuery<ImagemPost> typedQuery = getEntityManager().createQuery(jpql, ImagemPost.class);
        ImagemPost imagemPost = typedQuery.getSingleResult();
        return imagemPost;
    }

}
