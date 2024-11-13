import wikipediaapi
import sys

wiki_wiki = wikipediaapi.Wikipedia('en')
input=" ".join(sys.argv[1:])
result=input.replace('-',' ')
page_py = wiki_wiki.page(result)
result=page_py.summary.replace('‑','-').replace(' ',' ')
print(result)
'''print(page_py.summary.replace(' ',' '))
'''


