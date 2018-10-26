using namespace std;

void memcpy(void* dest, const void* src, unsigned int size)
{
    char* ps = (char*)src;
    char* pd = (char*)dest;
    char* psEnd = ps + size - 1;
    char* pdEnd = pd + size - 1;
    
    if (ps < pd) {
        while (psEnd >= src) {
            *pdEnd = *psEnd;
            pdEnd--;
            psEnd--;
        }
    } else {
        while (ps < psEnd) {
            *pd = *ps;
            pd++;
            ps++;
        }
    }
}