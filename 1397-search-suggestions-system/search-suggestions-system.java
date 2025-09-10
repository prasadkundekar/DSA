class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<String> sortedProducts = new ArrayList<>();
        List<List<String>>ans = new ArrayList<>();

        for(String st : products)
        {
            sortedProducts.add(st);
        }

        Collections.sort(sortedProducts);

        String search="";
        for(int i=0;i<searchWord.length();i++)
        {
            
             search += searchWord.charAt(i);
            List<String> innerValue = new ArrayList<>();

            int count=0;
            for(int j=0;j<sortedProducts.size();j++)
            {
                String listString = sortedProducts.get(j);
                boolean validString = true;

                if(listString.length()<search.length())
                continue;
                
                for(int k=0;k<search.length();k++)
                {
                    if(listString.charAt(k) != search.charAt(k))
                    {
                        validString = false;
                        break;
                    }
                }
                
                if(validString)
                {
                    innerValue.add(listString);
                    count++;
                }
                if(count==3)
                {
                    break;
                }
            }

            ans.add( new ArrayList<>(innerValue));
        }

        return ans;
    }
}