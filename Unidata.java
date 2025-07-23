// UniData.java
public class Unidata implements Comparable<Unidata> {
    private String rank2024;
    private String rank2023;
    private String institutionName;
    private String countryCode;
    private String country;
    private String size;
    private String focus;
    private String research;
    private String age;
    private String status;
    private String academicRepScore;
    private String academicRepRank;
    private String employerRepScore;
    private String employerRepRank;
    private String facultyStudentScore;
    private String facultyStudentRank;
    private String citationsScore;
    private String citationsRank;
    private String intlFacultyScore;
    private String intlFacultyRank;
    private String intlStudentsScore;
    private String intlStudentsRank;
    private String intlResearchScore;
    private String intlResearchRank;
    private String employmentScore;
    private String employmentRank;
    private String sustainabilityScore;
    private String sustainabilityRank;
    private String overallScore;
    
    public Unidata(String rank2024, String rank2023, String institutionName,
                   String countryCode, String country, String size, String focus,
                   String research, String age, String status, String academicRepScore,
                   String academicRepRank, String employerRepScore, String employerRepRank,
                   String facultyStudentScore, String facultyStudentRank, String citationsScore,
                   String citationsRank, String intlFacultyScore, String intlFacultyRank,
                   String intlStudentsScore, String intlStudentsRank, String intlResearchScore,
                   String intlResearchRank, String employmentScore, String employmentRank,
                   String sustainabilityScore, String sustainabilityRank, String overallScore) {
        this.rank2024 = rank2024;
        this.rank2023 = rank2023;
        this.institutionName = institutionName;
        this.countryCode = countryCode;
        this.country = country;
        this.size = size;
        this.focus = focus;
        this.research = research;
        this.age = age;
        this.status = status;
        this.academicRepScore = academicRepScore;
        this.academicRepRank = academicRepRank;
        this.employerRepScore = employerRepScore;
        this.employerRepRank = employerRepRank;
        this.facultyStudentScore = facultyStudentScore;
        this.facultyStudentRank = facultyStudentRank;
        this.citationsScore = citationsScore;
        this.citationsRank = citationsRank;
        this.intlFacultyScore = intlFacultyScore;
        this.intlFacultyRank = intlFacultyRank;
        this.intlStudentsScore = intlStudentsScore;
        this.intlStudentsRank = intlStudentsRank;
        this.intlResearchScore = intlResearchScore;
        this.intlResearchRank = intlResearchRank;
        this.employmentScore = employmentScore;
        this.employmentRank = employmentRank;
        this.sustainabilityScore = sustainabilityScore;
        this.sustainabilityRank = sustainabilityRank;
        this.overallScore = overallScore;
    }
    
    // Parse CSV line to UniData object
    public static Unidata fromCSV(String csvLine) {
        String[] fields = csvLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
    
       
        while (fields.length < 29) {
            String[] newFields = new String[fields.length + 1];
            System.arraycopy(fields, 0, newFields, 0, fields.length);
            newFields[fields.length] = "";
            fields = newFields;
        }
    
        for (int i = 0; i < fields.length; i++) {
            fields[i] = fields[i]
                            .replaceAll("^=+", "")      
                            .replaceAll("=+$", "")    
                            .replaceAll("^\"|\"$", "")   
                            .trim();                    
        }
    
        return new Unidata(
            fields[0], fields[1], fields[2], fields[3], fields[4],
            fields[5], fields[6], fields[7], fields[8], fields[9],
            fields[10], fields[11], fields[12], fields[13], fields[14],
            fields[15], fields[16], fields[17], fields[18], fields[19],
            fields[20], fields[21], fields[22], fields[23], fields[24],
            fields[25], fields[26], fields[27], fields[28]
        );
    }
    
    
    // Convert to CSV format
    public String toCSV() {
        return String.join(",",
            quote(rank2024), quote(rank2023), quote(institutionName),
            quote(countryCode), quote(country), quote(size), quote(focus),
            quote(research), quote(age), quote(status), quote(academicRepScore),
            quote(academicRepRank), quote(employerRepScore), quote(employerRepRank),
            quote(facultyStudentScore), quote(facultyStudentRank), quote(citationsScore),
            quote(citationsRank), quote(intlFacultyScore), quote(intlFacultyRank),
            quote(intlStudentsScore), quote(intlStudentsRank), quote(intlResearchScore),
            quote(intlResearchRank), quote(employmentScore), quote(employmentRank),
            quote(sustainabilityScore), quote(sustainabilityRank), quote(overallScore)
        );
    }
    
    // Helper method to quote fields if they contain commas
    private String quote(String field) {
        if (field == null) field = "";
        if (field.contains(",") || field.contains("\"") || field.contains("\n")) {
            return "\"" + field.replace("\"", "\"\"") + "\"";
        }
        return field;
    }

    public String getRank2024() {
        return rank2024;
    }

    public void setRank2024(String rank2024) {
        this.rank2024 = rank2024;
    }

    public String getRank2023() {
        return rank2023;
    }

    public void setRank2023(String rank2023) {
        this.rank2023 = rank2023;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAcademicRepScore() {
        return academicRepScore;
    }

    public void setAcademicRepScore(String academicRepScore) {
        this.academicRepScore = academicRepScore;
    }

    public String getAcademicRepRank() {
        return academicRepRank;
    }

    public void setAcademicRepRank(String academicRepRank) {
        this.academicRepRank = academicRepRank;
    }

    public String getEmployerRepScore() {
        return employerRepScore;
    }

    public void setEmployerRepScore(String employerRepScore) {
        this.employerRepScore = employerRepScore;
    }

    public String getEmployerRepRank() {
        return employerRepRank;
    }

    public void setEmployerRepRank(String employerRepRank) {
        this.employerRepRank = employerRepRank;
    }

    public String getFacultyStudentScore() {
        return facultyStudentScore;
    }

    public void setFacultyStudentScore(String facultyStudentScore) {
        this.facultyStudentScore = facultyStudentScore;
    }

    public String getFacultyStudentRank() {
        return facultyStudentRank;
    }

    public void setFacultyStudentRank(String facultyStudentRank) {
        this.facultyStudentRank = facultyStudentRank;
    }

    public String getCitationsScore() {
        return citationsScore;
    }

    public void setCitationsScore(String citationsScore) {
        this.citationsScore = citationsScore;
    }

    public String getCitationsRank() {
        return citationsRank;
    }

    public void setCitationsRank(String citationsRank) {
        this.citationsRank = citationsRank;
    }

    public String getIntlFacultyScore() {
        return intlFacultyScore;
    }

    public void setIntlFacultyScore(String intlFacultyScore) {
        this.intlFacultyScore = intlFacultyScore;
    }

    public String getIntlFacultyRank() {
        return intlFacultyRank;
    }

    public void setIntlFacultyRank(String intlFacultyRank) {
        this.intlFacultyRank = intlFacultyRank;
    }

    public String getIntlStudentsScore() {
        return intlStudentsScore;
    }

    public void setIntlStudentsScore(String intlStudentsScore) {
        this.intlStudentsScore = intlStudentsScore;
    }

    public String getIntlStudentsRank() {
        return intlStudentsRank;
    }

    public void setIntlStudentsRank(String intlStudentsRank) {
        this.intlStudentsRank = intlStudentsRank;
    }

    public String getIntlResearchScore() {
        return intlResearchScore;
    }

    public void setIntlResearchScore(String intlResearchScore) {
        this.intlResearchScore = intlResearchScore;
    }

    public String getIntlResearchRank() {
        return intlResearchRank;
    }

    public void setIntlResearchRank(String intlResearchRank) {
        this.intlResearchRank = intlResearchRank;
    }

    public String getEmploymentScore() {
        return employmentScore;
    }

    public void setEmploymentScore(String employmentScore) {
        this.employmentScore = employmentScore;
    }

    public String getEmploymentRank() {
        return employmentRank;
    }

    public void setEmploymentRank(String employmentRank) {
        this.employmentRank = employmentRank;
    }

    public String getSustainabilityScore() {
        return sustainabilityScore;
    }

    public void setSustainabilityScore(String sustainabilityScore) {
        this.sustainabilityScore = sustainabilityScore;
    }

    public String getSustainabilityRank() {
        return sustainabilityRank;
    }

    public void setSustainabilityRank(String sustainabilityRank) {
        this.sustainabilityRank = sustainabilityRank;
    }

    public String getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(String overallScore) {
        this.overallScore = overallScore;
    }
    @Override
    public int compareTo(Unidata other){
        return this.institutionName.compareToIgnoreCase(other.institutionName);
    }
    public static double mathRoundUpDown(double val) {
        if (val == 0) return 0;
        return Math.round(val);
    } 
    public static double safeParseDouble(String str){
        try {
        if (str == null || str.isEmpty() || str.equals("0")) return 0;
        return Double.parseDouble(str);
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }
    public String roundAllFields() {
        if (institutionName == null || institutionName.trim().equalsIgnoreCase("institution name")) return "";
    
        return String.join(",",
            quote(rank2024), quote(rank2023), quote(institutionName),
            quote(countryCode), quote(country), quote(size), quote(focus),
            quote(research), quote(age), quote(status),
            String.valueOf(mathRoundUpDown(safeParseDouble(academicRepScore))),
            quote(academicRepRank),
            String.valueOf(mathRoundUpDown(safeParseDouble(employerRepScore))),
            quote(employerRepRank),
            String.valueOf(mathRoundUpDown(safeParseDouble(facultyStudentScore))),
            quote(facultyStudentRank),
            String.valueOf(mathRoundUpDown(safeParseDouble(citationsScore))),
            quote(citationsRank),
            String.valueOf(mathRoundUpDown(safeParseDouble(intlFacultyScore))),
            quote(intlFacultyRank),
            String.valueOf(mathRoundUpDown(safeParseDouble(intlStudentsScore))),
            quote(intlStudentsRank),
            String.valueOf(mathRoundUpDown(safeParseDouble(intlResearchScore))),
            quote(intlResearchRank),
            String.valueOf(mathRoundUpDown(safeParseDouble(employmentScore))),
            quote(employmentRank),
            String.valueOf(mathRoundUpDown(safeParseDouble(sustainabilityScore))),
            quote(sustainabilityRank),
            String.valueOf(mathRoundUpDown(safeParseDouble(overallScore)))
        );
    }
    
    }       

    
