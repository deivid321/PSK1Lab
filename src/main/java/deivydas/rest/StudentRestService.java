package deivydas.rest;

import deivydas.entities.StudentEntity;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentRestService {

    @Inject private EntityManager em;

    @GET
    @Path("/{studentId}")
    public StudentEntity find(@PathParam("studentId") Integer studentId) {
        return em.find(StudentEntity.class, studentId);
    }

    @Path("/create")
    @PUT
    @Transactional
    public StudentEntity create(@QueryParam("firstName") String name,
                       @QueryParam("lastName") String surname,
                       @QueryParam("nr") String nr) {
        StudentEntity student = new StudentEntity();
        student.setFirstName(name);
        student.setLastName(surname);
        student.setRegistrationNo(nr);
        em.persist(student);
        return student;
    }

    @Path("/update/{id}")
    @POST @Transactional
    public Response update(@PathParam("id") long id,
                           @QueryParam("firstName") String name,
                           @QueryParam("lastName") String pwd,
                           @QueryParam("nr") String nr) {
        StudentEntity user = em.find(StudentEntity.class, id);
        if (user == null) {
            throw new IllegalArgumentException("user id "
                    + id + " not found");
        }
        user.setFirstName(name);
        user.setLastName(pwd);
        user.setRegistrationNo(nr);
        em.merge(user);
        return Response.ok(user).build(); // low level API
    }

}
