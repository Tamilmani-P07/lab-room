class SplitArray{
    public static void main(String[] args) {
        String s="Java is one of the most popular and widely used programming languages";
        String array[]=new String[11];
        char c[]=s.toCharArray();
        String temp="";int j=0;
        for(int i=0;i<c.length;i++)
        {
            if(c[i]!=' ')
            {
                temp=temp+c[i];
                // System.out.println(temp+" "+j);
            }
            if(i!=0 && c[i-1]!=' ' && c[i]==' '){
                array[j]=temp;
               // System.out.println(temp+" "+j);
                j++;
                temp="";
            }
        }
        for(int i=0;i<array.length-1;i++){
            System.out.println(array[i]);
        }
    }
}