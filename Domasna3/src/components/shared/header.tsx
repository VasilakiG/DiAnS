import { useMediaQuery } from "@chakra-ui/react";
import HeaderPC from "./header-pc";
//import HeaderMobile from "./header-mobile";

const Header = () => {

    const [isMobile] = useMediaQuery("(max-width: 800px)")

    return (
        <>

        {!isMobile &&
            <HeaderPC />
        }

        {/* {isMobile &&
            <HeaderMobile />
        } */}

        </>
    )
}

export default Header;