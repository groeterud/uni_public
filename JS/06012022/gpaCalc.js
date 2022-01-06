function gradeToNum(gradeList) {
    let numGradeList=[]
    for (let i = 0; i < gradeList.length; i++) {
        const grade = gradeList[i].toUpperCase();
        let grade_val=0.0;
        if (grade==="A") {
            grade_val=4.0;
        }
        else if (grade==="B") {
            grade_val=3.0
        }
        else if (grade==="C") {
            grade_val=2.0
        }
        else if (grade==="D") {
            grade_val=1.0
        }
        numGradeList.push(grade_val);
    }
    return numGradeList;
}

let sem1 = prompt("Enter grades for semester 1 seperated by space");
let sem2 = prompt("Enter grades for semester 2 seperated by space");

sem1=gradeToNum(sem1)
sem2=gradeToNum(sem2)

const sem1_gpa=((3*sem1[0])+(3*sem1[1])+(3*sem1[2])+(3*sem1[3]))/(3*4);
const sem2_gpa=((3*sem2[0])+(3*sem2[1])+(3*sem2[2])+(3*sem2[3]))/(3*4);

const cgpa = (sem1_gpa+sem2_gpa)/2;

