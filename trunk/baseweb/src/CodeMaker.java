import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;







public class CodeMaker
{
    public static void main(String[] args) throws Exception
    {
//        System.out.print("please input package name:");
//        BufferedReader read = new BufferedReader(new InputStreamReader(
//                System.in));  
//        String   getInput   =   read.readLine();//从控制台读取一行信息   
//        System.out.println(getInput);   
//        //read.close();   
//        System.out.print("please input bean name:");
//        read = new BufferedReader(new InputStreamReader(
//                System.in));  
//        getInput   =   read.readLine();//从控制台读取一行信息   
//        System.out.println(getInput);   
//        read.close();   
    	String basePath = "src/com/opencode/message/";
    	String basePackageName = "com.opencode.message";
    	String prefixName = "WorkMessage";
    	String beanPackageName = "com.opencode.bean";
    	String beanName = "TspWorkMessage";
    	String jspPath = "WebRoot/message/";
    	String jspForwardPath = "/message/";
    	String strutsConfigPath = "WebRoot/WEB-INF/struts-config.xml";
    	String actionServletPath = "WebRoot/WEB-INF/action-servlet.xml";
    	String applicationContextPath = "src/applicationContext.xml";
    	String resourcePath = "src/ApplicationResources.properties";
        String validationPath = "WebRoot/WEB-INF/validation.xml";
    	CodeMaker maker =  new CodeMaker();
        maker.make(basePath, basePackageName, prefixName, beanPackageName, beanName, jspPath, jspForwardPath, strutsConfigPath, actionServletPath, applicationContextPath, resourcePath,validationPath);
    }
//    private String daoPackage;
//    private String daoHibernatePackage;
//    private String bizPackage;
//    private String bizImpPackage;
//    private String actionPackage;
//    private String formPackage;
//    private String daoName;
//    private String daoHibernateName;
//    private String bizName;
//    private String bizImpName;
//    private String actionName;
//    private String formName;
    public static final String[] excludeProp = new String[]{"categoryAttributeValues","hashCode"};
    public void make(String basePath,String basePackageName,String prefixName,String beanPackageName,String beanName,String jspPath,String jspForwardPath,String strutsConfigPath,String actionServletPath,String applicationContextPath,String resourcePath,String validationPath) throws Exception
    {
//        makeDAOInterface(basePath,basePackageName, prefixName, beanPackageName, beanName);
//        makeDAOImp(basePath, basePackageName, prefixName, beanPackageName, beanName);
//        makeBizInterface(basePath, basePackageName, prefixName, beanPackageName, beanName);
//        makeBizImp(basePath, basePackageName, prefixName, beanPackageName, beanName);
//        makeActionForm(basePath, basePackageName, prefixName, beanPackageName, beanName);
//        makeEditAction(basePath, basePackageName, prefixName, beanPackageName, beanName);
//        makeSaveAction(basePath, basePackageName, prefixName, beanPackageName, beanName);
//        makeListAction(basePath, basePackageName, prefixName, beanPackageName, beanName);
//        makeListJSP(basePackageName, prefixName, beanPackageName, beanName, jspPath);        
        makeEditJSP(basePackageName, prefixName, beanPackageName, beanName, jspPath);
//        makeProp(prefixName, beanPackageName, beanName, resourcePath);
//        makeStrutsConfigXML(basePackageName, prefixName, jspForwardPath, strutsConfigPath);
//    	makeActionServletXML(basePackageName, prefixName, actionServletPath);
//    	makeApplicationContextXML(basePackageName, prefixName, applicationContextPath);
//        makeValidationXML(prefixName, beanPackageName, beanName, validationPath);
    }
    private void makeDAOInterface(String basePath,String basePackageName,String prefixName,String beanPackageName,String beanName) throws Exception
    {
        StringBuffer codeStr = new StringBuffer();
        codeStr.append("package " + basePackageName + ".dao;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("import java.util.List;" + "\r\n");
        codeStr.append("import " + beanPackageName + "." + beanName + ";" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("public interface " + prefixName + "Dao" + "\r\n");
        codeStr.append("{" + "\r\n");
        codeStr.append("    public void saveOrUpdate(" + beanName + " bean);" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public " + beanName + " get(Long id);" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public void delete(" + beanName + " bean);" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public void delete(String ids);" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public List findAll();" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public List findAll(int firstResult,int maxResults);" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public int findAllNum();" + "\r\n");
        codeStr.append("}" + "\r\n");
        System.out.println(codeStr.toString());
        File file = new File(basePath + "dao/" + prefixName + "Dao.java");
        if(!file.exists())
        {
        	file.getParentFile().mkdirs();
        	file.createNewFile();
        }
        FileWriter out = new FileWriter(file);
        out.write(codeStr.toString());
        out.close();
    }
    private void makeDAOImp(String basePath,String basePackageName,String prefixName,String beanPackageName,String beanName) throws Exception
    {
        StringBuffer codeStr = new StringBuffer();
        codeStr.append("package " + basePackageName + ".dao.hibernate;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("import java.sql.SQLException;" + "\r\n");
        codeStr.append("import java.util.List;" + "\r\n");
        codeStr.append("import " + beanPackageName + "." + beanName + ";" + "\r\n");
        codeStr.append("import " + basePackageName + ".dao." + prefixName + "Dao;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("import org.hibernate.HibernateException;" + "\r\n");
        codeStr.append("import org.hibernate.Query;" + "\r\n");
        codeStr.append("import org.hibernate.Session;" + "\r\n");
        codeStr.append("import org.springframework.orm.hibernate3.HibernateCallback;" + "\r\n");
        codeStr.append("import org.springframework.orm.hibernate3.support.HibernateDaoSupport;" + "\r\n");codeStr.append("" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("public class " + prefixName + "HibernateDao extends HibernateDaoSupport implements " + prefixName + "Dao" + "\r\n");
        codeStr.append("{" + "\r\n");
        codeStr.append("    public void saveOrUpdate(" + beanName + " bean)" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        this.getHibernateTemplate().saveOrUpdate(bean);" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public " + beanName + " get(Long id)" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        " + beanName + " bean = (" + beanName + ") this.getHibernateTemplate().get(" + beanName + ".class, new Integer(id.intValue()));" + "\r\n");
        codeStr.append("        return bean;" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public void delete(" + beanName + " bean)" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        this.getHibernateTemplate().delete(bean);" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public void delete(String ids)" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        String sql = \"delete " + beanName + " a where a.id in (\"+ids+\")\";" + "\r\n");
        codeStr.append("        this.getHibernateTemplate().bulkUpdate(sql);" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public List findAll()" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        String sql = \"From " + beanName + "\";" + "\r\n");
        codeStr.append("        List list = this.getHibernateTemplate().find(sql);" + "\r\n");
        codeStr.append("        return list;" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public List findAll(final int firstResult,final int maxResults)" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        final String sql = \"From " + beanName + "\";" + "\r\n");
        codeStr.append("        List list = this.getHibernateTemplate().executeFind(new HibernateCallback(){" + "\r\n");
        codeStr.append("        " + "\r\n");
        codeStr.append("        	public Object doInHibernate(Session session) throws HibernateException, SQLException" + "\r\n");
        codeStr.append("        	{" + "\r\n");
        codeStr.append("        		Query queryObject = session.createQuery(sql);" + "\r\n");
        codeStr.append("        		queryObject.setFirstResult(firstResult);" + "\r\n");
        codeStr.append("        		queryObject.setMaxResults(maxResults);" + "\r\n");
        codeStr.append("        		return queryObject.list();" + "\r\n");
        codeStr.append("        	}" + "\r\n");
        codeStr.append("        " + "\r\n");
        codeStr.append("        });" + "\r\n");
        codeStr.append("        return list;" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public int findAllNum()" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        String sql = \"select count(a.id) From " + beanName + " a\";" + "\r\n");
        codeStr.append("        List list = this.getHibernateTemplate().find(sql);" + "\r\n");
        codeStr.append("        int num = Integer.parseInt(list.get(0).toString());" + "\r\n");
        codeStr.append("        return num;" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("}" + "\r\n");
        System.out.println(codeStr.toString());
        File file = new File(basePath + "dao/hibernate/" + prefixName + "HibernateDao.java");
        if(!file.exists())
        {
        	file.getParentFile().mkdirs();
        	file.createNewFile();
        }
        FileWriter out = new FileWriter(file);
        out.write(codeStr.toString());
        out.close();
    }
    private void makeBizInterface(String basePath,String basePackageName,String prefixName,String beanPackageName,String beanName) throws Exception
    {
        StringBuffer codeStr = new StringBuffer();
        codeStr.append("package " + basePackageName + ".bizlogic;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("import java.util.List;" + "\r\n");
        codeStr.append("import com.opencode.common.BaseException;" + "\r\n");
        codeStr.append("import " + beanPackageName + "." + beanName + ";" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("public interface " + prefixName + "Biz" + "\r\n");
        codeStr.append("{" + "\r\n");
        codeStr.append("    public void saveOrUpdate(" + beanName + " bean) throws BaseException;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public " + beanName + " get(Long id) throws BaseException;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public void delete(" + beanName + " bean) throws BaseException;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public void delete(String ids) throws BaseException;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public List findAll() throws BaseException;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public List findAll(int firstResult,int maxResults) throws BaseException;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public int findAllNum() throws BaseException;" + "\r\n");
        codeStr.append("}" + "\r\n");
        System.out.println(codeStr.toString());
        File file = new File(basePath + "bizlogic/" + prefixName + "Biz.java");
        if(!file.exists())
        {
        	file.getParentFile().mkdirs();
        	file.createNewFile();
        }
        FileWriter out = new FileWriter(file);
        out.write(codeStr.toString());
        out.close();
    }
    private void makeBizImp(String basePath,String basePackageName,String prefixName,String beanPackageName,String beanName) throws Exception
    {
        StringBuffer codeStr = new StringBuffer();
        codeStr.append("package " + basePackageName + ".bizlogic.imp;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("import java.util.List;" + "\r\n");
        codeStr.append("import com.opencode.common.BaseException;" + "\r\n");
        codeStr.append("import " + beanPackageName + "." + beanName + ";" + "\r\n");
        codeStr.append("import " + basePackageName + ".bizlogic." + prefixName + "Biz;" + "\r\n");
        codeStr.append("import " + basePackageName + ".dao." + prefixName + "Dao;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("public class " + prefixName + "BizImp implements " + prefixName + "Biz" + "\r\n");
        codeStr.append("{" + "\r\n");
        codeStr.append("    private " + prefixName + "Dao " + firstCharToLower(prefixName + "Dao") + ";" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public void saveOrUpdate(" + beanName + " bean) throws BaseException" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        this.get" + prefixName + "Dao().saveOrUpdate(bean);" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public " + beanName + " get(Long id) throws BaseException" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        return this.get" + prefixName + "Dao().get(id);" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public void delete(" + beanName + " bean) throws BaseException" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        this.get" + prefixName + "Dao().delete(bean);" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public void delete(String ids) throws BaseException" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        this.get" + prefixName + "Dao().delete(ids);" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public List findAll() throws BaseException" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        return this.get" + prefixName + "Dao().findAll();" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public List findAll(int firstResult,int maxResults) throws BaseException" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        return this.get" + prefixName + "Dao().findAll(firstResult, maxResults);" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public int findAllNum() throws BaseException" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        return this.get" + prefixName + "Dao().findAllNum();" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public " + prefixName + "Dao get" + prefixName + "Dao()" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        return " + firstCharToLower(prefixName + "Dao") + ";" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("    public void set" + prefixName + "Dao(" + prefixName + "Dao " + firstCharToLower(prefixName + "Dao") + ")" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        this." + firstCharToLower(prefixName + "Dao") + " = " + firstCharToLower(prefixName + "Dao") + ";" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("}" + "\r\n");
        System.out.println(codeStr.toString());
        File file = new File(basePath + "bizlogic/imp/" + prefixName + "BizImp.java");
        if(!file.exists())
        {
        	file.getParentFile().mkdirs();
        	file.createNewFile();
        }
        FileWriter out = new FileWriter(file);
        out.write(codeStr.toString());
        out.close();
    }
    
    private void makeActionForm(String basePath,String basePackageName,String prefixName,String beanPackageName,String beanName) throws ClassNotFoundException, Exception
    {
    	StringBuffer codeStr = new StringBuffer();
        codeStr.append("package " + basePackageName + ".form;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("import com.opencode.common.BaseForm;" + "\r\n");
        codeStr.append("import com.opencode.common.DateUtil;" + "\r\n");
        codeStr.append("import " + beanPackageName + "." + beanName + ";" + "\r\n");
        codeStr.append("" + "\r\n");
        Class cls = Class.forName(beanPackageName + "." + beanName);
        Field[] fd = cls.getSuperclass().getDeclaredFields();
        
        codeStr.append("" + "\r\n");
        codeStr.append("public class " + prefixName + "Form extends BaseForm" + "\r\n");
        codeStr.append("{" + "\r\n");
        for (int i = 0; i < fd.length; i++)
		{
        	if(!isInExcludeProp(fd[i].getName()) && !Modifier.isStatic(fd[i].getModifiers()))
        	{
            	codeStr.append("	private String " + fd[i].getName() + ";" + "\r\n");
        	}
		}
        codeStr.append("" + "\r\n");
        for (int i = 0; i < fd.length; i++)
		{
        	if(!isInExcludeProp(fd[i].getName()) && !Modifier.isStatic(fd[i].getModifiers()))
        	{
        		codeStr.append("	public String get" + firstCharToUpper(fd[i].getName()) + "()" + "\r\n");
            	codeStr.append("	{" + "\r\n");
            	codeStr.append("		return " + fd[i].getName() +  ";" + "\r\n");
            	codeStr.append("	}" + "\r\n");
            	codeStr.append("" + "\r\n");
            	codeStr.append("	public void set" + firstCharToUpper(fd[i].getName()) + "(String " + fd[i].getName() + ")" + "\r\n");
            	codeStr.append("	{" + "\r\n");
            	codeStr.append("		this." + fd[i].getName() +  " = " + fd[i].getName() + ";" + "\r\n");
            	codeStr.append("	}" + "\r\n");
            	codeStr.append("" + "\r\n");
            	codeStr.append("" + "\r\n");
        	}
        	
		}
        codeStr.append("    public void setValue(" + beanName + " bean)" + "\r\n");
        codeStr.append("    {" + "\r\n");
        for (int i = 0; i < fd.length; i++)
		{
        	if(!isInExcludeProp(fd[i].getName()) && !Modifier.isStatic(fd[i].getModifiers()))
        	{
            	codeStr.append("		" + fd[i].getName() + " = bean.get" + firstCharToUpper(fd[i].getName()) + "();" + "\r\n");
        	}
		}
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public " + beanName + " getValue()" + "\r\n");
        codeStr.append("    {" + "\r\n");        
        codeStr.append("        " + beanName + " bean = new " + beanName + "();" + "\r\n");
        for (int i = 0; i < fd.length; i++)
		{
        	if(!isInExcludeProp(fd[i].getName()) && !Modifier.isStatic(fd[i].getModifiers()))
        	{
            	codeStr.append("		bean.set" + firstCharToUpper(fd[i].getName()) + "(" + fd[i].getName() +  ");" + "\r\n");
        	}
		}
        codeStr.append("        return bean;" + "\r\n");
        codeStr.append("    }" + "\r\n");        
        codeStr.append("}" + "\r\n");
        System.out.println(codeStr.toString());
        File file = new File(basePath + "form/" + prefixName + "Form.java");
        if(!file.exists())
        {
        	file.getParentFile().mkdirs();
        	file.createNewFile();
        }
        FileWriter out = new FileWriter(file);
        out.write(codeStr.toString());
        out.close();
    }
    
    private void makeEditAction(String basePath,String basePackageName,String prefixName,String beanPackageName,String beanName) throws Exception
    {
        StringBuffer codeStr = new StringBuffer();
        codeStr.append("package " + basePackageName + ".action;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("import javax.servlet.http.HttpServletRequest;" + "\r\n");
        codeStr.append("import org.apache.struts.action.ActionForm;" + "\r\n");
        codeStr.append("import com.opencode.common.BaseEditAction;" + "\r\n");
        codeStr.append("import " + beanPackageName + "." + beanName + ";" + "\r\n");
        codeStr.append("import " + basePackageName + ".bizlogic." + prefixName + "Biz;" + "\r\n");
        codeStr.append("import " + basePackageName + ".form." + prefixName + "Form;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("public class " + prefixName + "EditAction extends BaseEditAction" + "\r\n");
        codeStr.append("{" + "\r\n");
        codeStr.append("    private " + prefixName + "Biz " + firstCharToLower(prefixName + "Biz") + ";" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public void get(ActionForm form, HttpServletRequest request) throws Exception" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        " + prefixName + "Form myForm = (" + prefixName + "Form)form;" + "\r\n");
        codeStr.append("        String id = myForm.getId();" + "\r\n");
        codeStr.append("        if(id != null && !id.equals(\"\"))" + "\r\n");
        codeStr.append("        {" + "\r\n");
        codeStr.append("            " + beanName + " bean = this.get" + prefixName + "Biz().get(Long.parseLong(id));" + "\r\n");
        codeStr.append("            myForm.setValue(bean);" + "\r\n");
        codeStr.append("        }" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public " + prefixName + "Biz get" + prefixName + "Biz()" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        return " + firstCharToLower(prefixName + "Biz") + ";" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("    public void set" + prefixName + "Biz(" + prefixName + "Biz " + firstCharToLower(prefixName + "Biz") + ")" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        this." + firstCharToLower(prefixName + "Biz") + " = " + firstCharToLower(prefixName + "Biz") + ";" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("}" + "\r\n");
        System.out.println(codeStr.toString());
        File file = new File(basePath + "action/" + prefixName + "EditAction.java");
        if(!file.exists())
        {
        	file.getParentFile().mkdirs();
        	file.createNewFile();
        }
        FileWriter out = new FileWriter(file);
        out.write(codeStr.toString());
        out.close();
    }
    
    private void makeSaveAction(String basePath,String basePackageName,String prefixName,String beanPackageName,String beanName) throws Exception
    {
        StringBuffer codeStr = new StringBuffer();
        codeStr.append("package " + basePackageName + ".action;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("import javax.servlet.http.HttpServletRequest;" + "\r\n");
        codeStr.append("import org.apache.struts.action.ActionForm;" + "\r\n");
        codeStr.append("import com.opencode.common.BaseSaveAction;" + "\r\n");
        codeStr.append("import " + beanPackageName + "." + beanName + ";" + "\r\n");
        codeStr.append("import " + basePackageName + ".bizlogic." + prefixName + "Biz;" + "\r\n");
        codeStr.append("import " + basePackageName + ".form." + prefixName + "Form;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("public class " + prefixName + "SaveAction extends BaseSaveAction" + "\r\n");
        codeStr.append("{" + "\r\n");
        codeStr.append("    private " + prefixName + "Biz " + firstCharToLower(prefixName + "Biz") + ";" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public void save(ActionForm form, HttpServletRequest request) throws Exception" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        " + prefixName + "Form myForm = (" + prefixName + "Form)form;" + "\r\n");
        codeStr.append("        " + beanName + " bean = myForm.getValue();" + "\r\n");
        codeStr.append("        this.get" + prefixName + "Biz().saveOrUpdate(bean);" + "\r\n");
        codeStr.append("    	myForm.setMethod(\"success\");" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public " + prefixName + "Biz get" + prefixName + "Biz()" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        return " + firstCharToLower(prefixName + "Biz") + ";" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("    public void set" + prefixName + "Biz(" + prefixName + "Biz " + firstCharToLower(prefixName + "Biz") + ")" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        this." + firstCharToLower(prefixName + "Biz") + " = " + firstCharToLower(prefixName + "Biz") + ";" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("}" + "\r\n");
        System.out.println(codeStr.toString());
        File file = new File(basePath + "action/" + prefixName + "SaveAction.java");
        if(!file.exists())
        {
        	file.getParentFile().mkdirs();
        	file.createNewFile();
        }
        FileWriter out = new FileWriter(file);
        out.write(codeStr.toString());
        out.close();
    }
    
    private void makeListAction(String basePath,String basePackageName,String prefixName,String beanPackageName,String beanName) throws Exception
    {
        StringBuffer codeStr = new StringBuffer();
        codeStr.append("package " + basePackageName + ".action;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("import java.util.List;" + "\r\n");
        codeStr.append("import javax.servlet.http.HttpServletRequest;" + "\r\n");
        codeStr.append("import org.apache.struts.action.ActionForm;" + "\r\n");
        codeStr.append("import com.opencode.common.BaseListAction;" + "\r\n");
        codeStr.append("import " + basePackageName + ".bizlogic." + prefixName + "Biz;" + "\r\n");
        codeStr.append("import " + basePackageName + ".form." + prefixName + "Form;" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("public class " + prefixName + "ListAction extends BaseListAction" + "\r\n");
        codeStr.append("{" + "\r\n");
        codeStr.append("    private " + prefixName + "Biz " + firstCharToLower(prefixName + "Biz") + ";" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public void list(ActionForm form, HttpServletRequest request) throws Exception" + "\r\n");
        codeStr.append("    {" + "\r\n");        
        codeStr.append("        int totalNum = this.get" + prefixName + "Biz().findAllNum();" + "\r\n");
        codeStr.append("        " + prefixName + "Form myForm = (" + prefixName + "Form)form;" + "\r\n");
        codeStr.append("        myForm.setTotalNum(totalNum);" + "\r\n");
        codeStr.append("        myForm.calculate();" + "\r\n");
        codeStr.append("        int firstResult = (Integer.parseInt(myForm.getPage())-1) * myForm.getPageSize();" + "\r\n");
        codeStr.append("        int maxResults = myForm.getPageSize();" + "\r\n");
        codeStr.append("        List list = this.get" + prefixName + "Biz().findAll(firstResult, maxResults);" + "\r\n");
        codeStr.append("        request.setAttribute(\"resultSet\", list);" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public void delete(ActionForm form, HttpServletRequest request, String ids) throws Exception" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("    	this.get" + prefixName + "Biz().delete(ids);" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("" + "\r\n");
        codeStr.append("    public " + prefixName + "Biz get" + prefixName + "Biz()" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        return " + firstCharToLower(prefixName + "Biz") + ";" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("    public void set" + prefixName + "Biz(" + prefixName + "Biz " + firstCharToLower(prefixName + "Biz") + ")" + "\r\n");
        codeStr.append("    {" + "\r\n");
        codeStr.append("        this." + firstCharToLower(prefixName + "Biz") + " = " + firstCharToLower(prefixName + "Biz") + ";" + "\r\n");
        codeStr.append("    }" + "\r\n");
        codeStr.append("}" + "\r\n");
        System.out.println(codeStr.toString());
        File file = new File(basePath + "action/" + prefixName + "ListAction.java");
        if(!file.exists())
        {
        	file.getParentFile().mkdirs();
        	file.createNewFile();
        }
        FileWriter out = new FileWriter(file);
        out.write(codeStr.toString());
        out.close();
    }
    
    private void makeListJSP(String basePackageName,String prefixName,String beanPackageName,String beanName,String jspPath) throws ClassNotFoundException, Exception
    {
    	StringBuffer codeStr = new StringBuffer();
    	Class cls = Class.forName(beanPackageName + "." + beanName);
        Field[] fd = cls.getSuperclass().getDeclaredFields();
        
        codeStr.append("<%@ page contentType=\"text/html; charset=GBK\"%>" + "\r\n");    	
    	codeStr.append("<%@ taglib uri=\"/WEB-INF/struts-bean.tld\" prefix=\"bean\"%>" + "\r\n");
    	codeStr.append("<%@ taglib uri=\"/WEB-INF/struts-html.tld\" prefix=\"html\"%>" + "\r\n");
    	codeStr.append("<%@ taglib uri=\"/WEB-INF/struts-logic.tld\" prefix=\"logic\"%>" + "\r\n");
    	codeStr.append("<%@page import=\"com.opencode.common.BaseForm\"%>" + "\r\n");
    	codeStr.append("" + "\r\n");
    	codeStr.append("<html>" + "\r\n");
    	codeStr.append("	<head>" + "\r\n");
    	codeStr.append("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\">" + "\r\n");
    	codeStr.append("		<title><bean:message key=\"" + prefixName + "Form.listTitle\"/></title>" + "\r\n");
    	codeStr.append("		<LINK href=\"css/css.css\" rel=\"stylesheet\">" + "\r\n");
    	codeStr.append("		<script language=\"javascript\" type=\"text/javascript\" src=\"js/common.js\"></script>" + "\r\n");
    	codeStr.append("		<script type=\"text/javascript\">" + "\r\n");
    	codeStr.append("			function addOrEditItem(id)" + "\r\n");
    	codeStr.append("			{" + "\r\n");
    	codeStr.append("				var	win;" + "\r\n");
    	codeStr.append("				if(id == null)" + "\r\n");
    	codeStr.append("					win = showModalDialog(\"" + firstCharToLower(prefixName) + "Edit.do\",window,\"help:no;dialogWidth:200px;dialogHeight:150px;status:no;resizable:no;center:yes;scroll:yes;\");	" + "\r\n");
    	codeStr.append("				else" + "\r\n");
    	codeStr.append("					win = showModalDialog(\"" + firstCharToLower(prefixName) + "Edit.do?id=\"+id,window,\"help:no;dialogWidth:200px;dialogHeight:150px;status:no;resizable:no;center:yes;scroll:yes;\");	" + "\r\n");
    	codeStr.append("				if(win == \"ok\")" + "\r\n");
    	codeStr.append("				{" + "\r\n");
    	codeStr.append("					var f = document.forms[0];" + "\r\n");
    	codeStr.append("					f.method.value=\"search\";" + "\r\n");
    	codeStr.append("					f.submit();" + "\r\n");
    	codeStr.append("				}" + "\r\n");
    	codeStr.append("			}" + "\r\n");
    	codeStr.append("		</script>" + "\r\n");    	
    	codeStr.append("	</head>" + "\r\n");
    	codeStr.append("" + "\r\n");
    	codeStr.append("	<body>" + "\r\n");
    	codeStr.append("		<html:form action=\"" + firstCharToLower(prefixName) + "List.do\">" + "\r\n");
    	codeStr.append("			<html:hidden property=\"method\" />" + "\r\n");
    	codeStr.append("			<html:hidden property=\"page\" />" + "\r\n");
    	codeStr.append("			<TABLE class=\"tableList\">" + "\r\n");
    	codeStr.append("				<tr class=\"trHeader\">" + "\r\n");
    	codeStr.append("					<td class=\"tdHeader\">" + "\r\n");
    	codeStr.append("						<input type=\"checkbox\" name=\"checkAll\" class=\"checkboxCM\" onclick=\"checkAllBox()\"/>" + "\r\n");
    	codeStr.append("					</td>" + "\r\n");
    	codeStr.append("					<td class=\"tdHeader\">" + "\r\n");
    	codeStr.append("						序号" + "\r\n");
    	codeStr.append("					</td>" + "\r\n");
    	for (int i = 0; i < fd.length; i++)
		{
    		if(!isInExcludeProp(fd[i].getName()) && !Modifier.isStatic(fd[i].getModifiers()))
        	{
        		codeStr.append("					<td class=\"tdHeader\">" + "\r\n");
        		codeStr.append("						<bean:message key=\""+prefixName + "Form." + fd[i].getName()+"\"/>" + "\r\n");
        		codeStr.append("					</td>" + "\r\n");
        	}
		}
    	codeStr.append("					<td class=\"tdHeader\">" + "\r\n");
    	codeStr.append("						&nbsp;" + "\r\n");
    	codeStr.append("					</td>" + "\r\n");
    	codeStr.append("				</tr>" + "\r\n");
    	codeStr.append("				<logic:empty name=\"resultSet\">" + "\r\n");
    	codeStr.append("				<tr>" + "\r\n");
    	codeStr.append("					<td align=\"center\" colspan=\"3\">" + "\r\n");
    	codeStr.append("						没有任何数据！" + "\r\n");
    	codeStr.append("					</td>" + "\r\n");
    	codeStr.append("				</tr>" + "\r\n");
    	codeStr.append("				</logic:empty>	" + "\r\n");
    	codeStr.append("				<logic:notEmpty name=\"resultSet\">" + "\r\n");
    	codeStr.append("				<%" + "\r\n");
    	codeStr.append("					BaseForm form = (BaseForm)request.getAttribute(\"" + firstCharToLower(prefixName) + "Form\");" + "\r\n");
    	codeStr.append("					int intPage = Integer.parseInt(form.getPage());" + "\r\n");
    	codeStr.append("					int i = (intPage-1) * form.getPageSize() + 1;" + "\r\n");
    	codeStr.append("				%>" + "\r\n");    	
    	codeStr.append("				<logic:iterate id=\"item\" name=\"resultSet\">" + "\r\n");
    	codeStr.append("				<tr <%if(i%2==1) {%>class=\"trContext\"<%}else{ %>class=\"trContextNext\"<%} %>>" + "\r\n");
    	codeStr.append("					<td class=\"tdContextCheck\">" + "\r\n");
    	codeStr.append("						<input type=\"checkbox\" name=\"recordCheckBox\" class=\"checkboxItem\" value='<bean:write name=\"item\" property=\"id\"/>'>" + "\r\n");
    	codeStr.append("					</td>" + "\r\n");
    	codeStr.append("					<td class=\"tdContextIndex\">" + "\r\n");
    	codeStr.append("						<%=i++ %>" + "\r\n");
    	codeStr.append("					</td>" + "\r\n");
    	for (int i = 0; i < fd.length; i++)
		{
    		if(!isInExcludeProp(fd[i].getName()) && !Modifier.isStatic(fd[i].getModifiers()))
        	{
        		codeStr.append("					<td class=\"tdContext\">" + "\r\n");
        		codeStr.append("						<bean:write name=\"item\" property=\"" + fd[i].getName()+"\"/>" + "\r\n");
        		codeStr.append("					</td>" + "\r\n");
        	}
		}
    	codeStr.append("					<td class=\"tdContextEdit\">" + "\r\n");
    	codeStr.append("						<a href=\"#\" onclick=\"addOrEditItem('<bean:write name=\"item\" property=\"id\"/>')\">编辑</a>" + "\r\n");
    	codeStr.append("					</td>" + "\r\n");
    	codeStr.append("				</tr>" + "\r\n");
    	codeStr.append("				</logic:iterate>" + "\r\n");
    	codeStr.append("				</logic:notEmpty>" + "\r\n");    	
    	codeStr.append("			</TABLE>" + "\r\n");
    	codeStr.append("			<bean:write name=\"" + firstCharToLower(prefixName) + "Form\" property=\"pageString\" filter=\"false\"/>" + "\r\n");
    	codeStr.append("			" + "\r\n");
    	codeStr.append("			<table class=\"tableBottom\">" + "\r\n");
    	codeStr.append("				<tr class=\"trBottom\">" + "\r\n");
    	codeStr.append("					<td class=\"tdBottom\">" + "\r\n");
    	codeStr.append("						<input name=\"add\" type=\"button\" class=\"buttonCM\" value=\"增加\" onclick=\"addOrEditItem()\">" + "\r\n");
    	codeStr.append("						<input name=\"delete\" type=\"button\" class=\"buttonCM\" value=\"删除\" onclick=\"submitMe('delete')\">" + "\r\n");
    	codeStr.append("					</td>" + "\r\n");
    	codeStr.append("				</tr>" + "\r\n");
    	codeStr.append("			</table>" + "\r\n");
    	codeStr.append("		</html:form>" + "\r\n");
    	codeStr.append("	</body>" + "\r\n");
    	codeStr.append("</html>" + "\r\n");
    	System.out.println(codeStr.toString());
    	File file = new File(jspPath + firstCharToLower(prefixName) + "List.jsp");
        if(!file.exists())
        {
        	file.getParentFile().mkdirs();
        	file.createNewFile();
        }
        FileWriter out = new FileWriter(file);
        out.write(codeStr.toString());
        out.close();
    }
    
    private void makeEditJSP(String basePackageName,String prefixName,String beanPackageName,String beanName,String jspPath) throws ClassNotFoundException, Exception
    {
    	StringBuffer codeStr = new StringBuffer();
    	Class cls = Class.forName(beanPackageName + "." + beanName);
        Field[] fd = cls.getSuperclass().getDeclaredFields();
        
    	codeStr.append("<%@ page contentType=\"text/html; charset=GBK\"%>" + "\r\n");
    	codeStr.append("<%" + "\r\n");
    	codeStr.append("            response.setHeader(\"Pragma\", \"No-cache\");" + "\r\n");
    	codeStr.append("            response.setHeader(\"Cache-Control\", \"no-cache\");" + "\r\n");
    	codeStr.append("            response.setDateHeader(\"Expires\", 0);" + "\r\n");
    	codeStr.append("%>" + "\r\n");
    	codeStr.append("<%@ taglib uri=\"/WEB-INF/struts-bean.tld\" prefix=\"bean\"%>" + "\r\n");
    	codeStr.append("<%@ taglib uri=\"/WEB-INF/struts-html.tld\" prefix=\"html\"%>" + "\r\n");
    	codeStr.append("<%@ taglib uri=\"/WEB-INF/struts-logic.tld\" prefix=\"logic\"%>" + "\r\n");
    	codeStr.append("<logic:equal name=\"" + firstCharToLower(prefixName) + "Form\" property=\"method\" value=\"success\">" + "\r\n");
    	codeStr.append("	<script type=\"text/javascript\">" + "\r\n");
    	codeStr.append("		alert(\"保存成功\");" + "\r\n");
    	codeStr.append("		window.returnValue = \"ok\";" + "\r\n");
    	codeStr.append("		window.close();" + "\r\n");
    	codeStr.append("	</script>" + "\r\n");
    	codeStr.append("</logic:equal>" + "\r\n");
    	codeStr.append("" + "\r\n");
    	codeStr.append("<html>" + "\r\n");
    	codeStr.append("	<head>" + "\r\n");
    	codeStr.append("		<base target=\"_self\">" + "\r\n");
    	codeStr.append("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\">" + "\r\n");
    	codeStr.append("		<title><bean:message key=\"" + prefixName + "Form.editTitle\"/></title>" + "\r\n");
    	codeStr.append("		<LINK href=\"css/css.css\" rel=\"stylesheet\">" + "\r\n");
    	codeStr.append("	</head>" + "\r\n");
    	codeStr.append("" + "\r\n");
    	codeStr.append("	<body>" + "\r\n");
    	codeStr.append("		<html:form action=\"" + firstCharToLower(prefixName) + "Save.do\"  onsubmit=\"return submitMe('submit')\">" + "\r\n");
    	codeStr.append("			<html:hidden property=\"method\" />" + "\r\n");
    	codeStr.append("			<TABLE class=\"tableCM\">" + "\r\n");
    	for (int i = 0; i < fd.length; i++)
		{
    		if(!isInExcludeProp(fd[i].getName()) && !Modifier.isStatic(fd[i].getModifiers()))
        	{
    			codeStr.append("				<tr class=\"trCM\">" + "\r\n");
        		codeStr.append("					<td class=\"tdCMTitle\">" + "\r\n");
        		codeStr.append("						<bean:message key=\""+prefixName + "Form." + fd[i].getName()+"\"/>" + "\r\n");
        		codeStr.append("					</td>" + "\r\n");
        		codeStr.append("					<td class=\"tdCMContent\">" + "\r\n");
        		codeStr.append("						<html:text property=\"" + fd[i].getName()+"\"  styleClass=\"inputCM\"></html:text>" + "\r\n");
        		codeStr.append("					</td>" + "\r\n");
        		codeStr.append("				</tr>				" + "\r\n");
        	}
		}
    	codeStr.append("			</TABLE>" + "\r\n");
    	codeStr.append("			<p>" + "\r\n");
    	codeStr.append("			</p>" + "\r\n");
    	codeStr.append("			<table class=\"tableSubmit\">" + "\r\n");
    	codeStr.append("				<tr class=\"trSubmit\">" + "\r\n");
    	codeStr.append("					<td class=\"tdSubmitTitle\">" + "\r\n");
    	codeStr.append("						<input name=\"submitBt\" id=\"submitBt\" type=\"submit\" class=\"buttonCM\"" + "\r\n");
    	codeStr.append("							value=\"保存\">" + "\r\n");
    	codeStr.append("						&nbsp;&nbsp;" + "\r\n");
    	codeStr.append("						<input name=\"cancelBt\" id=\"cancelBt\" type=\"button\" class=\"buttonCM\"" + "\r\n");
    	codeStr.append("							value=\"取消\" onclick=\"javascript:window.close();\">" + "\r\n");
    	codeStr.append("					</td>" + "\r\n");
    	codeStr.append("					<td class=\"tdSubmitContent\"></td>" + "\r\n");
    	codeStr.append("				</tr>" + "\r\n");
    	codeStr.append("			</table>" + "\r\n");
    	codeStr.append("		</html:form>" + "\r\n");
    	codeStr.append("	</body>" + "\r\n");
    	codeStr.append("	<script type=\"text/javascript\">	" + "\r\n");
    	codeStr.append("		function submitMe(action)" + "\r\n");
    	codeStr.append("		{" + "\r\n");
    	codeStr.append("			var f = document.forms[0];					" + "\r\n");
    	codeStr.append("			f.action.value = action;" + "\r\n");
    	codeStr.append("			return validate"+prefixName + "Form(f);" + "\r\n");
    	codeStr.append("		}	" + "\r\n");
    	codeStr.append("	</script>" + "\r\n");
    	codeStr.append("	<html:javascript formName=\""+ firstCharToLower(prefixName) +"Form\"/>" + "\r\n");
    	codeStr.append("</html>" + "\r\n");
    	System.out.println(codeStr.toString());
    	File file = new File(jspPath + firstCharToLower(prefixName) + "Edit.jsp");
        if(!file.exists())
        {
        	file.getParentFile().mkdirs();
        	file.createNewFile();
        }
        FileWriter out = new FileWriter(file);
        out.write(codeStr.toString());
        out.close();
    }
    
    private void makeProp(String prefixName,String beanPackageName,String beanName,String resourcePath) throws Exception
    {
    	StringBuffer codeStr = new StringBuffer();
    	Class cls = Class.forName(beanPackageName + "." + beanName);
        Field[] fd = cls.getSuperclass().getDeclaredFields();
        File file = new File(resourcePath);
        codeStr.append(prefixName + "Form.editTitle=" + "\r\n");
        codeStr.append(prefixName + "Form.listTitle=" + "\r\n");
        for (int i = 0; i < fd.length; i++)
		{
        	if(!isInExcludeProp(fd[i].getName()) && !Modifier.isStatic(fd[i].getModifiers()))
        	{
        		codeStr.append(prefixName + "Form." + fd[i].getName() + "=" + "\r\n");
        	}        	
		}
        System.out.println(codeStr.toString());
        
        FileReader rd = new FileReader(file);
        BufferedReader bf = new BufferedReader(rd);
        ArrayList al = new ArrayList();
        String str = null;
        while((str = bf.readLine()) != null)
        {
            al.add(str);
        }
        bf.close();
        al.add("#");
        al.add(codeStr.toString());
        FileWriter wt = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(wt);
        for(int i=0;i<al.size();i++)
        {
            bw.write(al.get(i) + "\r\n");
        }
        bw.close();
    }
    
    private void makeStrutsConfigXML(String basePackageName,String prefixName,String jspForwardPath,String strutsConfigPath) throws Exception
    {
    	SAXBuilder builder = new SAXBuilder();
		File f = new File(strutsConfigPath);
		
		Document doc = builder.build(f);
		Element root = doc.getRootElement();
		Element beans = root.getChild("form-beans");
		Element bean = new Element("form-bean");
		bean.setAttribute("name", firstCharToLower(prefixName) + "Form");
		bean.setAttribute("type",basePackageName + ".form." + prefixName + "Form");
		beans.addContent(bean);
		
		Element actions = root.getChild("action-mappings");
		Element actionList = new Element("action");
		actionList.setAttribute("path", "/" + firstCharToLower(prefixName) + "Edit");
		actionList.setAttribute("type", "org.springframework.web.struts.DelegatingActionProxy");
		actionList.setAttribute("name", firstCharToLower(prefixName) + "Form");
		actionList.setAttribute("scope", "request");
		Element pathList = new Element("forward");
		pathList.setAttribute("name", "success");
		pathList.setAttribute("path", jspForwardPath + firstCharToLower(prefixName) + "Edit.jsp");
		actionList.addContent(pathList);
		actions.addContent(actionList);
		
		Element actionEdit = new Element("action");
		actionEdit.setAttribute("path", "/" + firstCharToLower(prefixName) + "Save");
		actionEdit.setAttribute("type", "org.springframework.web.struts.DelegatingActionProxy");
		actionEdit.setAttribute("name", firstCharToLower(prefixName) + "Form");
		actionEdit.setAttribute("scope", "request");
		Element pathEdit = new Element("forward");
		pathEdit.setAttribute("name", "success");
		pathEdit.setAttribute("path", jspForwardPath + firstCharToLower(prefixName) + "Edit.jsp");
		actionEdit.addContent(pathEdit);
		actions.addContent(actionEdit);
		
		Element actionSave = new Element("action");
		actionSave.setAttribute("path", "/" + firstCharToLower(prefixName) + "List");
		actionSave.setAttribute("type", "org.springframework.web.struts.DelegatingActionProxy");
		actionSave.setAttribute("name", firstCharToLower(prefixName) + "Form");
		actionSave.setAttribute("scope", "request");
		Element pathSave = new Element("forward");
		pathSave.setAttribute("name", "success");
		pathSave.setAttribute("path", jspForwardPath + firstCharToLower(prefixName) + "List.jsp");
		actionSave.addContent(pathSave);
		actions.addContent(actionSave);
		
		
		XMLOutputter out = new XMLOutputter("	",true);
		FileOutputStream outStr = new FileOutputStream(f);
		out.output(doc, outStr);
		outStr.close();
    }
    
    private void makeActionServletXML(String basePackageName,String prefixName,String actionServletPath) throws Exception
    {
    	SAXBuilder builder = new SAXBuilder();
		File f = new File(actionServletPath);
		
		Document doc = builder.build(f);
		Element root = doc.getRootElement();
		
		
		Element beanList = new Element("bean");
		beanList.setAttribute("name", "/" + firstCharToLower(prefixName) + "List");
		beanList.setAttribute("class", basePackageName + ".action." + prefixName + "ListAction");
		Element propertyList = new Element("property");
		propertyList.setAttribute("name", firstCharToLower(prefixName) + "Biz");
		Element refList = new Element("ref");
		refList.setAttribute("bean",firstCharToLower(prefixName) + "Biz");
		propertyList.addContent(refList);
		beanList.addContent(propertyList);
		root.addContent(beanList);
		
		Element beanEdit = new Element("bean");
		beanEdit.setAttribute("name", "/" + firstCharToLower(prefixName) + "Edit");
		beanEdit.setAttribute("class", basePackageName + ".action." + prefixName + "EditAction");
		Element propertyEdit = new Element("property");
		propertyEdit.setAttribute("name", firstCharToLower(prefixName) + "Biz");
		Element refEdit = new Element("ref");
		refEdit.setAttribute("bean",firstCharToLower(prefixName) + "Biz");
		propertyEdit.addContent(refEdit);
		beanEdit.addContent(propertyEdit);
		root.addContent(beanEdit);
		
		Element beanSave = new Element("bean");
		beanSave.setAttribute("name", "/" + firstCharToLower(prefixName) + "Save");
		beanSave.setAttribute("class", basePackageName + ".action." + prefixName + "SaveAction");
		Element propertySave = new Element("property");
		propertySave.setAttribute("name", firstCharToLower(prefixName) + "Biz");
		Element refSave = new Element("ref");
		refSave.setAttribute("bean",firstCharToLower(prefixName) + "Biz");
		propertySave.addContent(refSave);
		beanSave.addContent(propertySave);
		root.addContent(beanSave);
		
		
		XMLOutputter out = new XMLOutputter("	",true);
		FileOutputStream outStr = new FileOutputStream(f);
		out.output(doc, outStr);
		outStr.close();
    }
    
    private void makeApplicationContextXML(String basePackageName,String prefixName,String applicationContextPath) throws Exception
    {
    	SAXBuilder builder = new SAXBuilder();
		File f = new File(applicationContextPath);
		
		Document doc = builder.build(f);
		Element root = doc.getRootElement();
		
		
		Element beanDao = new Element("bean");
		beanDao.setAttribute("name", firstCharToLower(prefixName) + "Dao");
		beanDao.setAttribute("class", basePackageName + ".dao.hibernate." + prefixName + "HibernateDao");
		Element propertyList = new Element("property");
		propertyList.setAttribute("name", "sessionFactory");
		Element refList = new Element("ref");
		refList.setAttribute("bean","sessionFactory");
		propertyList.addContent(refList);
		beanDao.addContent(propertyList);
		root.addContent(beanDao);
		
		Element beanBiz = new Element("bean");
		beanBiz.setAttribute("name", firstCharToLower(prefixName) + "Biz");
		beanBiz.setAttribute("parent", "txProxyTemplate");
		Element propertyEdit = new Element("property");
		propertyEdit.setAttribute("name", "target");
		Element bean = new Element("bean");
		bean.setAttribute("class",basePackageName + ".bizlogic.imp." + prefixName + "BizImp");
		Element property = new Element("property");
		property.setAttribute("name",firstCharToLower(prefixName) + "Dao");
		property.setAttribute("ref",firstCharToLower(prefixName) + "Dao");
		bean.addContent(property);
		propertyEdit.addContent(bean);
		beanBiz.addContent(propertyEdit);
		root.addContent(beanBiz);
		
		
		XMLOutputter out = new XMLOutputter("	",true);
		FileOutputStream outStr = new FileOutputStream(f);
		out.output(doc, outStr);
		outStr.close();
    }
    
    private void makeValidationXML(String prefixName,String beanPackageName,String beanName,String validationPath) throws Exception
    {
    	SAXBuilder builder = new SAXBuilder();
		File f = new File(validationPath);
		
		Document doc = builder.build(f);
		Element formset = doc.getRootElement().getChild("formset");
		
		Element form = new Element("form");
		form.setAttribute("name", firstCharToLower(prefixName) + "Form");
		
		Class cls = Class.forName(beanPackageName + "." + beanName);
        Field[] fd = cls.getSuperclass().getDeclaredFields();
        
        for (int i = 0; i < fd.length; i++)
		{
        	if(!isInExcludeProp(fd[i].getName()) && !Modifier.isStatic(fd[i].getModifiers()))
        	{
        		Element field = new Element("field");
        		field.setAttribute("property", fd[i].getName());
        		field.setAttribute("depends", "required");
        		Element arg0 = new Element("arg0");
        		arg0.setAttribute("key", prefixName + "Form." + fd[i].getName());
        		
        		field.addContent(arg0);
        		form.addContent(field);
        	}        	
		}
        formset.addContent(form);
        
        XMLOutputter out = new XMLOutputter("	",true);
		FileOutputStream outStr = new FileOutputStream(f);
		out.output(doc, outStr);
		outStr.close();
    }
    
    private String firstCharToLower(String input)
    {
        char[] chars = input.toCharArray();
        String rs = (chars[0]+"").toLowerCase() + input.substring(1);
        return rs;
    }
    
    private String firstCharToUpper(String input)
    {
        char[] chars = input.toCharArray();
        String rs = (chars[0]+"").toUpperCase() + input.substring(1);
        return rs;
    }
    
    private boolean isInExcludeProp(String str)
    {
    	boolean isIn = false;
    	for(int i=0;i<excludeProp.length;i++)
    	{
    		if(excludeProp[i].equals(str))
    		{
    			isIn = true;
    			break;
    		}
    	}
    	return isIn;
    }
    
	
}
