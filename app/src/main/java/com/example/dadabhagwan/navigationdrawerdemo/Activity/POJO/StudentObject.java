package com.example.dadabhagwan.navigationdrawerdemo.Activity.POJO;

/**
 * Created by dadabhagwan on 11/28/2016.
 */
        import java.util.HashMap;
        import java.util.Map;
    //    import javax.annotation.Generated;

//@Generated("org.jsonschema2pojo")
public class StudentObject {

    private String studentId;
    private String studentName;
    private String studentMarks;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     *
     * @param studentId
     * The StudentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     *
     * @return
     * The studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     *
     * @param studentName
     * The StudentName
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     *
     * @return
     * The studentMarks
     */
    public String getStudentMarks() {
        return studentMarks;
    }

    /**
     *
     * @param studentMarks
     * The StudentMarks
     */
    public void setStudentMarks(String studentMarks) {
        this.studentMarks = studentMarks;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}