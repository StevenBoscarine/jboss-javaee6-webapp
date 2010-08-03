package com.mycompany;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import static org.junit.Assert.*;
import javax.inject.Inject;
import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.api.asset.ByteArrayAsset;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Arquillian.class)
public class MemberRegistrationTest
{
   @Deployment
   public static Archive<?> createTestArchive() {
      return ShrinkWrap.create(WebArchive.class, "test.war")
         .addClasses(Member.class, MemberRegistration.class, MemberRepository.class, MemberRepositoryProducer.class)
         // SLF4J libraries required only if not available on the container classpath
//         .addLibraries(
//               MavenArtifactResolver.resolve("org.slf4j:slf4j-api:1.5.10"),
//               MavenArtifactResolver.resolve("org.slf4j:slf4j-jdk14:1.5.10")
//         )
         .addWebResource("test-persistence.xml", "classes/META-INF/persistence.xml")
         .addWebResource(new ByteArrayAsset(new byte[0]), "beans.xml");
   }

   @Inject MemberRegistration memberRegistration;

   @Inject Logger log;

   @Test
   public void testRegister() throws Exception
   {
      Member newMember = memberRegistration.getNewMember();
      newMember.setName("Jane Doe");
      newMember.setEmail("jane@mailinator.com");
      newMember.setPhoneNumber("2125551234");
      memberRegistration.register();
      assertNotNull(newMember.getId());
      log.info(newMember.getName() + " was persisted with id " + newMember.getId());
   }

   @Produces
   public Logger produceLog(InjectionPoint injectionPoint)
   {
      return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
   }
}
