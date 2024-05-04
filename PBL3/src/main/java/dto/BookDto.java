
package dto;

/**
 *
 * @author 84775
 */
public class BookDto {
    private Integer categoryId;
    private String name;
    private Integer count;

    public BookDto() {
    }

    public BookDto(Integer categoryId, String name, Integer count) {
        this.categoryId = categoryId;
        this.name = name;
        this.count = count;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BookDto{" + "categoryId=" + categoryId + ", name=" + name + ", count=" + count + '}';
    }
    
    
}
