class Test
{
    public void SumTwoMin(int[] list)
    {
        int midPoint = list.length/2;
        int sum = 0;
        int less = list[0];
        for(int i = 0; i < midPoint;i++)
        {
            if(list[i] <= less)
            {
                less = list[i];
            }
        }
        sum += less;
        less = list[midPoint];
        for(int j = midPoint ; j < list.length;j++)
        {
            if(list[j] <= less)
            {
                less = list[i];
            }
        }
        sum += less;
        return sum;
    }




    public void OddEvenRow(int[][] grid)
    {
        for(int row = 0 ; row < grid.length;column++)
        {
            if(grid[row].length % 2 == 0)
            {
                System.out.println("EVEN");
                continue;
            }
            else
            {
                System.out.println("ODD");
            }
        }
    }

    public Student[] createStu(Student[] stuList)
    {
        Student[] tempList = new Student[2];
        Student stu1;
        Student stu2;

        for(Student student:stuList)
        {
            if(student.GetAvg() == 90)
            {
                stu1 = student;
                
            }else if(student.GetAvg() == 75)
            {
                stu2 = student;
            }
        }
        tempList[0] = stu1;
        tempList[1] = stu2;

        return tempList;


    }
}