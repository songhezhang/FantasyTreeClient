package com.fantasystep.persistence.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import com.fantasystep.domain.Node;
//import com.fantasystep.domain.TestMongo2;
import com.fantasystep.persistence.TreeManagerSubclassHolder;
import com.fantasystep.persistence.client.TreeManagerWSService;
import com.fantasystep.persistence.exception.InvalidCredentialsException;
import com.fantasystep.persistence.exception.PermissionDeniedException;
import com.fantasystep.persistence.exception.PersistenceException;
import com.fantasystep.persistence.exception.UnauthorizedException;
import com.fantasystep.utils.ConstantUtil;
import com.fantasystep.utils.NodeClassUtil;

public class Test {
	public static void main(String[] args) {
		TreeManagerWSService service = new TreeManagerWSService();
		try {
			System.out.println(NodeClassUtil.getSubClassesInJVM( Node.class, true ));
			boolean a = service.getTreeManagerPort()
					.activate(UUID.randomUUID());
			UUID sessionKey = service.getTreeManagerPort().authenticate("bhuang", "Binbin526");
			Map<String, List<String>> requestHeaders = new HashMap<String, List<String>>();
			TreeManagerSubclassHolder holder = service.getTreeManagerPort();
			requestHeaders.put(ConstantUtil.SESSION_KEY, Arrays.asList(sessionKey.toString()));
			((BindingProvider)holder).getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
//			service.getTreeManagerPort()
//			Node node = holder.getNodeByID(UUID.fromString("e3e8ae71-46da-46ef-ad76-c9dc6d1b7853"));
//			Node node2 = holder.getFullNodeByID(UUID.fromString("be2f06b7-949d-454c-bf45-c49265b89991"));
//			for(Node n : node2.getChildren())
//				if(n.getClass().equals(Node.class)) {
//					Node nn = JSON2NodeUtil.json2Node(n.getSerializationNode(), TestMongo2.class);
//					System.out.println(nn);
//				}
			System.out.println();
//			System.out.println(JSON2NodeUtil.node2Json(node));
//			Node co = JSON2NodeUtil.json2Node(JSON2NodeUtil.node2Json(node), Node.class);
//			User user = new User();
//			user.setFirstName("test");
//			user.setLastName("test");
//			user.setEmail("a@gmail.com");
//			user.setPassword("test");
//			user.setUsername("test");
//			user.setBirthday(new Date());
//			user.setDeleted(false);
//			user.setGender(GenderEnum.MAN);
//			user.setLabel("User");
////			user.setAdministrationNodeId(UUID.fromString("e3e8ae71-46da-46ef-ad76-c9dc6d1b7853"));
//			user.setActivated(true);
//			user.setComment("Just test");
//			user.setParentId(UUID.fromString("e5501d2f-65bf-488a-badf-be5e0dd6c574"));
//			user.setId(UUID.randomUUID());
//			holder.insertTreeNode(user);
			
			System.out.println(a);
		} 
		catch (InvalidCredentialsException e) {
			e.printStackTrace();
		}
		catch (PersistenceException e) {
			e.printStackTrace();
//		} catch (UniqueViolateException e) {
//			e.printStackTrace();
//		} catch (RequiredFieldMissingException e) {
//			e.printStackTrace();
//		} catch (UnauthorizedException e) {
//			e.printStackTrace();
////		} catch (ValidationFailedException e) {
////			e.printStackTrace();
//		} catch (PermissionDeniedException e) {
//			e.printStackTrace();
		}
	}
}
