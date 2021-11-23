package org.VTI.Repository;

import org.VTI.Entity.Position;
import org.VTI.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PositionRepository {
    private HibernateUtils hibernateUtils;

    public PositionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Position> getAllPosition(){
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<Position> query = session.createQuery("FROM Position");

            return query.list();

        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            if (session != null){
                session.close();
            }
        }
    }




    public void createPosition (Position position){
        Session session = null;

        try {
            session =hibernateUtils.openSession();

            session.save(position);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            if (session != null) session.close();
        }
    }


}
