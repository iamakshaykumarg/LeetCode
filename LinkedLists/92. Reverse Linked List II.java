class Solution {
    //Using BFS to solve the problem.
    HashSet<String> set;
    Queue<String> q;
    public int slidingPuzzle(int[][] board) {
        
        q = new LinkedList<>();
        set = new HashSet<>();
        String result = "123450";
        StringBuilder s = new StringBuilder();
        for(int i=0;i<2;i++)
            for(int j=0;j<3;j++)
                s.append((char)(board[i][j]+'0'));
        // System.out.println(s);
        q.offer(s.toString());
        set.add(s.toString());
        int count=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String temp = q.poll();
                if(temp.equals(result))
                    return count;
                trace(temp);
            }
            count++;
        }
        
        return -1;
    }
    void trace(String s){
        int i = s.indexOf('0');
        
        if(i==0 || i==3){
            char[] c = s.toCharArray();
            char temp = c[i+1];
            c[i+1]=c[i];
            c[i]=temp;
            String x = new String(c);
            if(!set.contains(x)){
                q.offer(x);
                set.add(x);
            }
                
            
            int tmp = (i+3)%6;
            c = s.toCharArray();
            temp = c[tmp];
            c[tmp]=c[i];
            c[i]=temp;
            x = new String(c);
            if(!set.contains(x)){
                q.offer(x);
                set.add(x);
            }
        }
        else if(i==2 || i==5){
            char[] c = s.toCharArray();
            char temp = c[i-1];
            c[i-1]=c[i];
            c[i]=temp;
            String x = new String(c);
            if(!set.contains(x)){
                q.offer(x);
                set.add(x);
            }
            
            int tmp = (i+3)%6;
            c = s.toCharArray();
            temp = c[tmp];
            c[tmp]=c[i];
            c[i]=temp;
            x = new String(c);
            if(!set.contains(x)){
                q.offer(x);
                set.add(x);
            }
        }
        else{
            char[] c = s.toCharArray();
            char temp = c[i+1];
            c[i+1]=c[i];
            c[i]=temp;
            String x = new String(c);
            if(!set.contains(x)){
                q.offer(x);
                set.add(x);
            }
            
            c = s.toCharArray();
            temp = c[i-1];
            c[i-1]=c[i];
            c[i]=temp;
            x = new String(c);
            if(!set.contains(x)){
                q.offer(x);
                set.add(x);
            }
            
            int tmp = (i+3)%6;
            c = s.toCharArray();
            temp = c[tmp];
            c[tmp]=c[i];
            c[i]=temp;
            x = new String(c);
            if(!set.contains(x)){
                q.offer(x);
                set.add(x);
            }
            
        }
    }
    
}
