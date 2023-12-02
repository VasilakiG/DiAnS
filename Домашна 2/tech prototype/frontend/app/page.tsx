import { VStack } from "@chakra-ui/react";
import Image from "next/image";

export default function Home() {
	return (
    	<>
			<VStack
				background={"white"}
				h={"auto"}
				w={"100vw"}
			>
				<Image
					src="/landingPhoto.png"
					alt="MacedoniaTimeless"
					height="1000"
					width="1330" 
				/>
			</VStack>
    	</>
	);
};
