package lesson4;

import com.geekbrains.db.dao.CategoriesMapper;
import com.geekbrains.db.dao.ProductsMapper;
import com.geekbrains.db.model.Categories;
import com.geekbrains.db.model.Products;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lesson5.ApiSearchResult;
import lesson5.SpoonaccularService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        User user = User.builder()
                .setName("Ivan")
                .setSurname("Ivanov")
                .setAddress("Address")
                .setEmail("123@ya.ru")
                .build();
        SpoonaccularService spoonaccularService = new SpoonaccularService();
        ApiSearchResult recipes = spoonaccularService.findRecipes("Bread", 3);
        System.out.println(recipes);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("myBatisConfig.xml"));

        try (SqlSession session = sessionFactory.openSession()) {
            ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
            CategoriesMapper categoriesMapper = session.getMapper(CategoriesMapper.class);
            Products product = productsMapper.selectByPrimaryKey(444L);
            System.out.println(product);
            Categories category = categoriesMapper.selectByPrimaryKey(product.getCategoryId());
            System.out.println(category);

            // DSL - domain specific language

            RequestSpecification requestSpecification =  // Вход. Для решения вопросов query, path, URL, apikey, log, body. А также GET,POST,PUT,DELETE
                    new RequestSpecBuilder()
                            .build();
        }
    }
}
