package deivydas.mybatis.model;

public class Dormitory {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DORMITORY.ID
     *
     * @mbg.generated Sat Mar 25 11:16:48 EET 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DORMITORY.STREET
     *
     * @mbg.generated Sat Mar 25 11:16:48 EET 2017
     */
    private String street;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DORMITORY.STREET_NUMBER
     *
     * @mbg.generated Sat Mar 25 11:16:48 EET 2017
     */
    private Integer streetNumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DORMITORY.ID
     *
     * @return the value of PUBLIC.DORMITORY.ID
     *
     * @mbg.generated Sat Mar 25 11:16:48 EET 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DORMITORY.ID
     *
     * @param id the value for PUBLIC.DORMITORY.ID
     *
     * @mbg.generated Sat Mar 25 11:16:48 EET 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DORMITORY.STREET
     *
     * @return the value of PUBLIC.DORMITORY.STREET
     *
     * @mbg.generated Sat Mar 25 11:16:48 EET 2017
     */
    public String getStreet() {
        return street;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DORMITORY.STREET
     *
     * @param street the value for PUBLIC.DORMITORY.STREET
     *
     * @mbg.generated Sat Mar 25 11:16:48 EET 2017
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DORMITORY.STREET_NUMBER
     *
     * @return the value of PUBLIC.DORMITORY.STREET_NUMBER
     *
     * @mbg.generated Sat Mar 25 11:16:48 EET 2017
     */
    public Integer getStreetNumber() {
        return streetNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DORMITORY.STREET_NUMBER
     *
     * @param streetNumber the value for PUBLIC.DORMITORY.STREET_NUMBER
     *
     * @mbg.generated Sat Mar 25 11:16:48 EET 2017
     */
    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }
}