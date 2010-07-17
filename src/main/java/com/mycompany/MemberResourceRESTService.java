package com.mycompany;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
/**
 * JAX-RS Example
 * 
 * This class produces a RESTful service to read the contents of the members table.   
 */
@Path("/members")
@RequestScoped
public class MemberResourceRESTService
{
   private static final String ALL_MEMBERS = "select m from Member m order by m.name";
   @Inject
   @MemberRepository
   private EntityManager em;

   @GET
   public List<Member> listAllMembers()
   {
      @SuppressWarnings("unchecked") // Force IDE to ignore warnings about "genericizing" the results of this query
      final List<Member> results = em.createQuery(ALL_MEMBERS).getResultList();
      return results;
   }

   @GET
   @Path("/{id:[1-9][0-9]*}")
   public Member lookupMemberById(@PathParam("id") long id)
   {
      return em.find(Member.class, id);
   }
}
